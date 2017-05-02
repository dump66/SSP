package de.hofuniversity.ssp.data;

public class Match {

    private int	    id;
    private int	    season;
    private String  date;
    private int	    visitors;
    private String  referee;
    private Stadium stadium;
    private String  finalScore;
    private String  htScore;
    private int	    ptsHome;
    private int	    ptsGuest;
    private Team    homeTeam;
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
