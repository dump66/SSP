package de.hofuniversity.ssp.teams;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class Team {

    private int		 teamID;
    private String	 teamName;
    private URL		 teamIconURL;
    private String	 stadion;
    private List<String> players;

    public Team() {

    }

    public int getTeamID() {
	return teamID;
    }

    public void setTeamID(int teamID) {
	this.teamID = teamID;
    }

    public String getTeamName() {
	return teamName;
    }

    public void setTeamName(String teamName) {
	this.teamName = teamName;
    }

    public URL getTeamIconURL() {
	return teamIconURL;
    }

    public void setTeamIconURL(String teamIconURL) {
	try {
	    this.teamIconURL = new URL(teamIconURL);
	} catch (MalformedURLException e) {
	    System.out.println("Warning: Could not create URL. Check XML File. URL-String:" + System.lineSeparator() + teamIconURL);
	}
    }

    public String getStadion() {
	return stadion;
    }

    public void setStadion(String stadion) {
	this.stadion = stadion;
    }

    public List<String> getPlayers() {
	if (this.players == null) {
	    this.players = new LinkedList<String>();
	}
	return players;
    }

    public void addPlayer(String player) {
	getPlayers().add(player);
    }

    @Override
    public String toString() {
	return getTeamName() + "(" + getTeamID() + "): " + getStadion();
    }
}
