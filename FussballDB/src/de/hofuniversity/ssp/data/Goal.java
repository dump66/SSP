package de.hofuniversity.ssp.data;

public class Goal {

    private int	   id;
    private int	   goalHome;
    private int	   goalGuest;
    private int	   minute;
    private Player player;
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
