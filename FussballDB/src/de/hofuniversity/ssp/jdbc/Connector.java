package de.hofuniversity.ssp.jdbc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Driver;
// Written by Andreas Schultze
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import de.hofuniversity.ssp.data.Goal;
import de.hofuniversity.ssp.data.Match;
import de.hofuniversity.ssp.data.Player;
import de.hofuniversity.ssp.data.Stadium;
import de.hofuniversity.ssp.data.Team;
import de.hofuniversity.ssp.jdom.MatchParser;
import de.hofuniversity.ssp.jdom.TeamsParser;

public class Connector {

    public Connection getConnection() throws Exception {
	Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
	DriverManager.registerDriver(driver);
	// Hier eventuell den Datenbank-Namen anpassen
	Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fussballdb", "Student", "Hof");
	return c;
    }

    private void executeStatement(String sql) throws Exception {
	Statement stmt = (Statement) getConnection().createStatement();
	if (sql.contains(";")) {
	    String[] ssql = sql.split("[;]");
	    for (String s : ssql) {
		stmt.execute(s.endsWith(";") ? s.substring(0, s.length() - 1) : s);
	    }
	} else {
	    stmt.execute(sql);
	}
	stmt.close();
    }

    private String getDDL(String name) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(name)));
	String line, sql = "";
	while ((line = br.readLine()) != null) {
	    sql += line;
	}
	br.close();
	return sql;
    }

    // private void importTeam(List<Team> teams) throws Exception{
    // executeStatement(getDDL("SQL/team.sql"));
    // Statement stmt = getConnection().createStatement();
    // for (Team t: teams){
    // String sql = "insert into verein(i_id, v_name, v_logo) values(" +
    // t.getId() + ",'" + t.getName() + "','" + t.getIcon() + "');";
    // System.out.println(sql);
    // stmt.execute(sql);
    // }
    // stmt.close();
    // }

    private void importElements(List elements) throws Exception {
	Statement stmt = getConnection().createStatement();
	for (Object o : elements) {
	    String sql = "";
	    if (o instanceof Team) {
		Team t = (Team) o;
		sql = "insert into verein(i_id, v_name, v_logo, fk_stadion) values(" + t.getId() + ",'" + t.getName() + "','" + t.getIcon()
			+ "'," + t.getStadium().getId() + ");";
	    } else if (o instanceof Player) {
		Player p = (Player) o;
		sql = "insert into spieler(i_id, v_name, fk_verein) values(" + p.getId() + ",'" + p.getName() + "'," + p.getTeam().getId()
			+ ");";
	    } else if (o instanceof Stadium) {
		Stadium s = (Stadium) o;
		sql = "insert into stadion(i_id, v_name) values(" + s.getId() + ",'" + s.getName() + "');";
	    } else if (o instanceof Match) {
		Match m = (Match) o;
		sql = "insert into spiel(i_id, i_saison, v_datum, i_zuschauer, fk_stadion, v_endergebnis, v_hzergebnis, i_punkteHeim, i_punkteGast, fk_heimVerein, fk_gastVerein) "
			+ "values(" + m.getId() + "," + m.getSeason() + ",'" + m.getDate() + "'," + m.getVisitors() + "," + m.getStadium().getId() + ",'" + m.getFinalScore() + "','" + m.getHtScore() + "'," + m.getPtsHome() + "," + m.getPtsGuest() + "," + m.getHomeTeam().getId() + "," + m.getGuestTeam().getId() +");";
	    } else if (o instanceof Goal) {
		Goal g = (Goal) o;
		sql = "insert into tor(i_id, i_torHeim, i_torGast, i_minute, fk_spieler, fk_spiel) "
			+ "values(" + g.getId() + "," + g.getGoalHome() + "," + g.getGoalGuest() + "," + g.getMinute() + "," + g.getPlayer().getId() + "," + g.getMatch().getId() + ");";
	    } else {
		throw new Exception("Invalid element in list of parameter in importElements");
	    }
	    System.out.println(sql);
	    stmt.execute(sql);
	}
	stmt.close();
    }

    public static void main(String[] args) throws Exception {
	Connector con = new Connector();
	con.executeStatement(con.getDDL("/team.sql"));
	TeamsParser tParser = new TeamsParser("/teams.xml");
	tParser.parse();
	MatchParser mParser = new MatchParser("/matches.xml");
	mParser.parse();
	con.importElements(tParser.getTeamList());
	con.importElements(tParser.getPlayerList());
	con.importElements(tParser.getStadiumList());
	con.importElements(mParser.getMatchList());
	con.importElements(mParser.getGoalList());
    }

}
