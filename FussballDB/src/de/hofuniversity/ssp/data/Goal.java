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

@Entity(name="tor")
public class Goal implements Serializable{

    @Id
    @GeneratedValue
    @Column(name="i_id")
    private int	   id;
    @Column(name="i_torHeim")
    private int	   goalHome;
    @Column(name="i_torGast")
    private int	   goalGuest;
    @Column(name="i_minute")
    private int	   minute;
    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="fk_spieler")
    private Player player;
    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="fk_spiel")
    private Match  match;

    public Goal() {

    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getGoalHome() {
	return goalHome;
    }

    public void setGoalHome(int goalHome) {
	this.goalHome = goalHome;
    }

    public int getGoalGuest() {
	return goalGuest;
    }

    public void setGoalGuest(int goalGuest) {
	this.goalGuest = goalGuest;
    }

    public int getMinute() {
	return minute;
    }

    public void setMinute(int minute) {
	this.minute = minute;
    }

    public Player getPlayer() {
	return player;
    }

    public void setPlayer(Player player) {
	this.player = player;
    }

    public Match getMatch() {
	return match;
    }

    public void setMatch(Match match) {
	this.match = match;
    }

    @Override
    public String toString() {
	return "Goal [id=" + id + ", goalsHome=" + goalHome + ", goalsGuest=" + goalGuest + ", minute=" + minute + ", player=" + player
		+ ", match=" + match + "]";
    }

}
