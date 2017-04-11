package de.hofuniversity.ssp.jdbc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import de.hofuniversity.ssp.data.Team;
import de.hofuniversity.ssp.jdom.TeamsParser;
import de.hofuniversity.ssp.test.Database;

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
		stmt.execute(s.endsWith(";") ? s.substring(0, s.length()-1) : s);
	    }
	} else {
	    stmt.execute(sql);
	}
	stmt.close();
    }

    private String getDDL(String name) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(name)));
	String line, sql = "";
	while ((line = br.readLine()) != null) {
	    sql += line;
	}
	br.close();
	return sql;
    }
    
    private void importTeam(List<Team> teams) throws Exception{
	executeStatement(getDDL("SQL/team.sql"));
	Statement stmt = getConnection().createStatement();
	for (Team t: teams){
	    String sql = "insert into verein(id, name, logo) values(" + t.getId() + ",'" + t.getName() + "','" + t.getIcon() + "');";
	    System.out.println(sql);
	    stmt.execute(sql);
	}
	stmt.close();
    }

    public static void main(String[] args) throws Exception {
	Connector con = new Connector();
	TeamsParser parser = new TeamsParser("XML/teams.xml");
	parser.parse();
	con.importTeam(parser.getTeamList());
    }

}
