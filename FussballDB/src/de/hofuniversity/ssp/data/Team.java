package de.hofuniversity.ssp.data;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class Team {

    private int		 id;
    private String	 name;
    private URL		 icon;
    private Stadium	 stadium;
    private List<Player> players;

    public Team() {
	
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public URL getIcon() {
	return icon;
    }

    public void setIcon(String icon) {
	try {
	    this.icon = new URL(icon);
	} catch (MalformedURLException e) {
	    System.out.println("Warning: Could not create URL. Check XML File. URL-String:" + System.lineSeparator() + icon);
	}
    }

    public List<Player> getPlayers() {
	if (this.players == null) {
	    this.players = new LinkedList<Player>();
	}
	return players;
    }

    public void addPlayer(Player player) {
	getPlayers().add(player);
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    @Override
    public String toString() {
	return getName() + "(" + getId() + "): " + getStadium();
    }
}
