package de.hofuniversity.ssp.data;

public class Goal {

    private int	   id;
    private int	   goalsHome;
    private int	   goalsGuest;
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

    public int getGoalsHome() {
	return goalsHome;
    }

    public void setGoalsHome(int goalsHome) {
	this.goalsHome = goalsHome;
    }

    public int getGoalsGuest() {
	return goalsGuest;
    }

    public void setGoalsGuest(int goalsGuest) {
	this.goalsGuest = goalsGuest;
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
	return "Goal [id=" + id + ", goalsHome=" + goalsHome + ", goalsGuest=" + goalsGuest + ", minute=" + minute + ", player=" + player
		+ ", match=" + match + "]";
    }

}
