package de.hofuniversity.ssp.matches;

public class Goal {

    private int goalID;
    private int goalMatchID;
    private int goalScoreTeam1;
    private int goalScoreTeam2;
    private int goalMatchMinute;
    private int goalGetterID;
    private String goalGetterName;
    private boolean goalPenalty;
    private boolean goalOwnGoal;
    private boolean goalOvertime;
    
    public Goal(){
	
    }

    public int getGoalID() {
        return goalID;
    }

    public void setGoalID(int goalID) {
        this.goalID = goalID;
    }

    public int getGoalMatchID() {
        return goalMatchID;
    }

    public void setGoalMatchID(int goalMatchID) {
        this.goalMatchID = goalMatchID;
    }

    public int getGoalScoreTeam1() {
        return goalScoreTeam1;
    }

    public void setGoalScoreTeam1(int goalScoreTeam1) {
        this.goalScoreTeam1 = goalScoreTeam1;
    }

    public int getGoalScoreTeam2() {
        return goalScoreTeam2;
    }

    public void setGoalScoreTeam2(int goalScoreTeam2) {
        this.goalScoreTeam2 = goalScoreTeam2;
    }

    public int getGoalMatchMinute() {
        return goalMatchMinute;
    }

    public void setGoalMatchMinute(int goalMatchMinute) {
        this.goalMatchMinute = goalMatchMinute;
    }

    public int getGoalGetterID() {
        return goalGetterID;
    }

    public void setGoalGetterID(int goalGetterID) {
        this.goalGetterID = goalGetterID;
    }

    public String getGoalGetterName() {
        return goalGetterName;
    }

    public void setGoalGetterName(String goalGetterName) {
        this.goalGetterName = goalGetterName;
    }

    public boolean isGoalPenalty() {
        return goalPenalty;
    }

    public void setGoalPenalty(boolean goalPenalty) {
        this.goalPenalty = goalPenalty;
    }

    public boolean isGoalOwnGoal() {
        return goalOwnGoal;
    }

    public void setGoalOwnGoal(boolean goalOwnGoal) {
        this.goalOwnGoal = goalOwnGoal;
    }

    public boolean isGoalOvertime() {
        return goalOvertime;
    }

    public void setGoalOvertime(boolean goalOvertime) {
        this.goalOvertime = goalOvertime;
    }

    @Override
    public String toString() {
	return "Goal [goalID=" + goalID + ", goalMatchID=" + goalMatchID + ", goalScoreTeam1=" + goalScoreTeam1 + ", goalScoreTeam2="
		+ goalScoreTeam2 + ", goalMatchMinute=" + goalMatchMinute + ", goalGetterID=" + goalGetterID + ", goalGetterName="
		+ goalGetterName + ", goalPenalty=" + goalPenalty + ", goalOwnGoal=" + goalOwnGoal + ", goalOvertime=" + goalOvertime + "]";
    }
    
    
}
