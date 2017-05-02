package de.hofuniversity.ssp.data;

public class Player {

    private static int idCounter = 1;
    
    private int	   id;
    private String name;
    private String position;
    private String birthdate;
    private String nation;
    private String picture;
    private Team   team;

    public Player() {
	this.id = idCounter++;
    }

    public int getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getPosition() {
	return position;
    }

    public void setPosition(String position) {
	this.position = position;
    }

    public String getBirthdate() {
	return birthdate;
    }

    public void setBirthdate(String birthdate) {
	this.birthdate = birthdate;
    }

    public String getNation() {
	return nation;
    }

    public void setNation(String nation) {
	this.nation = nation;
    }

    public String getPicture() {
	return picture;
    }

    public void setPicture(String picture) {
	this.picture = picture;
    }

    public Team getTeam() {
	return team;
    }

    public void setTeam(Team team) {
	this.team = team;
    }

    @Override
    public String toString() {
	return "Player [id=" + id + ", name=" + name + ", position=" + position + ", birthdate=" + birthdate + ", nation=" + nation
		+ ", picture=" + picture + ", team=" + team + "]";
    }

}
