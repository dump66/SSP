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

@Entity(name="spiel")
public class Match implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name="i_id")
    private int	    id;
    @Column(name="i_saison")
    private int	    season;
    @Column(name="v_datum")
    private String  date;
    @Column(name="i_zuschauer")
    private int	    visitors;
    @Column(name="v_schiri")
    private String  referee;
    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="fk_stadion")
    private Stadium stadium;
    @Column(name="v_endergebnis")
    private String  finalScore;
    @Column(name="v_hzergebnis")
    private String  htScore;
    @Column(name="i_punkteHeim")
    private int	    ptsHome;
    @Column(name="i_punkteGast")
    private int	    ptsGuest;
    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="fk_heimVerein")
    private Team    homeTeam;
    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="fk_gastVerein")
    private Team    guestTeam;

    public Match() {

    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getSeason() {
	return season;
    }

    public void setSeason(int season) {
	this.season = season;
    }

    public String getDate() {
	return date;
    }

    public void setDate(String date) {
	this.date = date;
    }

    public int getVisitors() {
	return visitors;
    }

    public void setVisitors(int visitors) {
	this.visitors = visitors;
    }

    public String getReferee() {
	return referee;
    }

    public void setReferee(String referee) {
	this.referee = referee;
    }

    public Stadium getStadium() {
	return stadium;
    }

    public void setStadium(Stadium stadium) {
	this.stadium = stadium;
    }

    public String getFinalScore() {
	return finalScore;
    }

    public void setFinalScore(String finalScore) {
	this.finalScore = finalScore;
    }

    public String getHtScore() {
	return htScore;
    }

    public void setHtScore(String htScore) {
	this.htScore = htScore;
    }

    public int getPtsHome() {
	return ptsHome;
    }

    public void setPtsHome(int ptsHome) {
	this.ptsHome = ptsHome;
    }

    public int getPtsGuest() {
	return ptsGuest;
    }

    public void setPtsGuest(int ptsGuest) {
	this.ptsGuest = ptsGuest;
    }

    public Team getHomeTeam() {
	return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
	this.homeTeam = homeTeam;
    }

    public Team getGuestTeam() {
	return guestTeam;
    }

    public void setGuestTeam(Team guestTeam) {
	this.guestTeam = guestTeam;
    }

    @Override
    public String toString() {
	return "Match [id=" + id + ", season=" + season + ", date=" + date + ", visitors=" + visitors + ", referee=" + referee
		+ ", stadium=" + stadium + ", finalScore=" + finalScore + ", htScore=" + htScore + ", ptsHome=" + ptsHome + ", ptsGuest="
		+ ptsGuest + ", homeTeam=" + homeTeam + ", guestTeam=" + guestTeam + "]";
    }

}
