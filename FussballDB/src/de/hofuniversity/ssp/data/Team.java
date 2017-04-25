package de.hofuniversity.ssp.data;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;

public class Team {

    private int		 id;
    private String	 name;
    private Time founding;
    private String coach;
    private String president;
    private String city;
    private URL		 icon;
    private Stadium	 stadium;

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

    public Stadium getStadium() {
	return stadium;
    }

    public void setStadium(Stadium stadium) {
	this.stadium = stadium;
    }

    public Time getFounding() {
        return founding;
    }

    public void setFounding(Time founding) {
        this.founding = founding;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
	return "Team [id=" + id + ", name=" + name + ", founding=" + founding + ", coach=" + coach + ", president=" + president + ", city="
		+ city + ", icon=" + icon + ", stadium=" + stadium + "]";
    }

}
