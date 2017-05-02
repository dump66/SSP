package de.hofuniversity.ssp.jdom;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import de.hofuniversity.ssp.data.Player;
import de.hofuniversity.ssp.data.Stadium;
import de.hofuniversity.ssp.data.Team;

public class TeamsParser {

    private Document		 doc;
    private static List<Team>	 teamList;
    private static List<Stadium> stadiumList;
    private static List<Player>	 playerList;

    public TeamsParser(String filename) throws JDOMException, IOException {
	doc = new SAXBuilder().build(filename);
	this.teamList = new LinkedList<Team>();
	this.stadiumList = new LinkedList<Stadium>();
	this.playerList = new LinkedList<Player>();
    }

    public void parse() throws JDOMException, IOException {
	Element root = doc.getRootElement();
	List<Element> teams = root.getChildren();
	for (Element e : teams) {
	    Team currentTeam = new Team();
	    Stadium s = new Stadium();
	    s.setName(e.getChildText("stadion"));
	    this.stadiumList.add(s);
	    currentTeam.setStadium(s);
	    currentTeam.setIcon(e.getChildText("teamIconURL"));
	    currentTeam.setId(Integer.parseInt(e.getChildText("teamID")));
	    currentTeam.setName(e.getChildText("teamName"));
	    for (Element player : e.getChildren("player")) {
		Player p = new Player();
		p.setName(player.getText());
		p.setTeam(currentTeam);
		this.playerList.add(p);
	    }
	    teamList.add(currentTeam);
	}

    }

    public static List<Team> getTeamList() {
	return teamList;
    }

    public static List<Stadium> getStadiumList() {
	return stadiumList;
    }

    public static List<Player> getPlayerList() {
	return playerList;
    }

}
