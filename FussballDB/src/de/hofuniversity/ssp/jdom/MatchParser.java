package de.hofuniversity.ssp.jdom;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import de.hofuniversity.ssp.data.Goal;
import de.hofuniversity.ssp.data.Match;
import de.hofuniversity.ssp.data.Player;
import de.hofuniversity.ssp.data.Team;

public class MatchParser {

    private Document	doc;
    private List<Goal>	goalList;
    private List<Match>	matchList;

    public MatchParser(String filename) throws JDOMException, IOException {
	doc = new SAXBuilder().build(getClass().getResourceAsStream(filename));
	this.goalList = new LinkedList<Goal>();
	this.matchList = new LinkedList<Match>();
    }

    public void parse() throws Exception {
	Element root = doc.getRootElement();
	List<Element> matches = root.getChildren();
	for (Element m : matches) {
	    Match match = new Match();
	    // Allgemein
	    int home = Integer.parseInt(m.getChildText("idTeam1"));
	    int guest = Integer.parseInt(m.getChildText("idTeam2"));

	    // Spiel
	    // ID
	    match.setId(Integer.parseInt(m.getChildText("matchID")));

	    // Saison
	    match.setSeason(Integer.parseInt(m.getChildText("leagueSaison")));

	    // Datum
	    match.setDate(m.getChildText("matchDateTime"));

	    // Zuschauer
	    String visitors = m.getChildText("NumberOfViewers");
	    if (visitors.isEmpty()) {
		match.setVisitors(-1);
	    } else {
		match.setVisitors(Integer.parseInt(visitors));
	    }

	    // Endstand & HZ-Stand & Punkte
	    Element results = m.getChild("matchResults");
	    for (Element result : results.getChildren()) {
		int homeScore = Integer.parseInt(m.getChildText("pointsTeam1"));
		int guestScore = Integer.parseInt(m.getChildText("pointsTeam2"));
		// Endergebnis
		if (result.getChildText("resultName").equalsIgnoreCase("Endergebnis")) {
		    match.setFinalScore(homeScore + ":" + guestScore);
		    // Punkte
		    if (homeScore > guestScore) {
			match.setPtsHome(3);
			match.setPtsGuest(0);
		    } else if (homeScore == guestScore) {
			match.setPtsHome(1);
			match.setPtsGuest(1);
		    } else {
			match.setPtsHome(0);
			match.setPtsGuest(3);
		    }
		} else if (result.getChildText("resultName").equalsIgnoreCase("Halbzeit")) {
		    match.setHtScore(result.getChildText("pointsTeam1") + ":" + result.getChildText("pointsTeam2"));
		}
	    }

	    // Heimteam & Gastteam & Stadion
	    for (Team t : TeamsParser.getTeamList()) {
		if (t.getId() == home) {
		    match.setHomeTeam(t);
		    match.setStadium(t.getStadium());
		} else if (t.getId() == guest) {
		    match.setGuestTeam(t);
		}
	    }

	    // Spiel speichern
	    matchList.add(match);

	    // Tore
	    Element goals = m.getChild("goals");
	    Goal goalBefore = null;
	    for (Element g : goals.getChildren()) {
		Goal goal = new Goal();

		// ID
		goal.setId(Integer.parseInt(g.getChildText("goalID")));
		// Heimtor
		goal.setGoalHome(Integer.parseInt(g.getChildText("goalScoreTeam1")));

		// Gasttor
		goal.setGoalGuest(Integer.parseInt(g.getChildText("goalScoreTeam2")));

		// Minute
		goal.setMinute(Integer.parseInt(g.getChildText("goalMatchMinute")));

		// Spieler
		String player = g.getChildText("goalGetterName");
		Player p = getPlayer(player, match.getHomeTeam(), match.getGuestTeam());
		if (p == null) {
		    Team scorerTeam = null;
		    if (goalBefore == null) {
			if (goal.getGoalHome() == 1) {
			    scorerTeam = match.getHomeTeam();
			} else {
			    scorerTeam = match.getGuestTeam();
			}
		    } else {
			if (goal.getGoalHome() > goalBefore.getGoalHome()) {
			    scorerTeam = match.getHomeTeam();
			} else if (goal.getGoalGuest() > goalBefore.getGoalGuest()) {
			    scorerTeam = match.getGuestTeam();
			} else {
			    throw new Exception("Error: Goal did not increase scores!");
			}
		    }
		    p = new Player();
		    p.setName(player);
		    p.setTeam(scorerTeam);
		    TeamsParser.getPlayerList().add(p);
		}
		goal.setPlayer(p);

		// Spiel
		goal.setMatch(match);

		// Tor speichern
		goalList.add(goal);
		goalBefore = goal;
	    }
	}

    }

    private Player getPlayer(String player, Team homeTeam, Team guestTeam) {
	String[] xmlNames = player.split(" ");
	String xmlLastName = xmlNames[xmlNames.length - 1];

	List<Player> players = TeamsParser.getPlayerList();
	for (Player p : players) {
	    String fullname = p.getName();
	    String[] names = fullname.split(" ");
	    String lastName = names[names.length - 1];

	    if (lastName.equalsIgnoreCase(xmlLastName)) {
		if (p.getTeam().getId() == homeTeam.getId() || p.getTeam().getId() == guestTeam.getId()) {
		    return p;
		}
	    }
	}

	return null;
    }

    public List<Goal> getGoalList() {
	return goalList;
    }

    public List<Match> getMatchList() {
	return matchList;
    }
}
