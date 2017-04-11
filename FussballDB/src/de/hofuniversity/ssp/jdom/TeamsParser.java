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
    
    private Document doc;
    private List<Team> teamList;
    
    public TeamsParser(String filename) throws JDOMException, IOException{
	doc = new SAXBuilder().build(filename);
	this.teamList = new LinkedList<Team>();
    }

    public void parse() throws JDOMException, IOException {
	Element root = doc.getRootElement();
	List<Element> teams = root.getChildren();
	for (Element e : teams){
	    Team currentTeam = new Team();
	    currentTeam.setStadium(new Stadium(e.getChildText("stadion")));
	    currentTeam.setIcon(e.getChildText("teamIconURL"));
	    currentTeam.setId(Integer.parseInt(e.getChildText("teamID")));
	    currentTeam.setName(e.getChildText("teamName"));
	    for(Element player : e.getChildren("player")){
		currentTeam.addPlayer(new Player(player.getText()));
	    }
	    teamList.add(currentTeam);
	}
	
    }
    
    public List<Team> getTeamList() {
        return teamList;
    }
}
