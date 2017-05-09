package de.hofuniversity.ssp.data;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="spieler")
public class Player implements Serializable{

    private static int idCounter = 1;
    
    @Id
    @GeneratedValue
    @Column(name="i_id")
    private int	   id;
    @Column(name="v_name")
    private String name;
    @Column(name="v_position")
    private String position;
    @Column(name="v_geburtsdatum")
    private String birthdate;
    @Column(name="v_nation")
    private String nation;
    @Column(name="v_bild")
    private String picture;
    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="fk_verein")
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
