package de.hofuniversity.ssp.matches;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

public class Matchdata {

    private int		      matchID;
    private GregorianCalendar matchDateTime;
    private int		      groupID;
    private int		      groupOrderID;
    private String	      groupName;
    private int		      leagueID;
    private String	      leagueName;
    private int		      leageSaison;
    private String	      leagueShortcut;
    private int		      idTeam1;
    private int		      idTeam2;
    private int		      pointsTeam1;
    private int		      pointsTeam2;
    private boolean	      matchIsFinished;
    private List<MatchResult> matchResults;
    private List<Goal>	      goals;
    private Location	      location;
    private int		      numberOfViewers;

    public Matchdata(){
	
    }

    public int getMatchID() {
        return matchID;
    }

    public void setMatchID(int matchID) {
        this.matchID = matchID;
    }

    public GregorianCalendar getMatchDateTime() {
        return matchDateTime;
    }

    public void setMatchDateTime(GregorianCalendar matchDateTime) {
        this.matchDateTime = matchDateTime;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public int getGroupOrderID() {
        return groupOrderID;
    }

    public void setGroupOrderID(int groupOrderID) {
        this.groupOrderID = groupOrderID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getLeagueID() {
        return leagueID;
    }

    public void setLeagueID(int leagueID) {
        this.leagueID = leagueID;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public int getLeageSaison() {
        return leageSaison;
    }

    public void setLeageSaison(int leageSaison) {
        this.leageSaison = leageSaison;
    }

    public String getLeagueShortcut() {
        return leagueShortcut;
    }

    public void setLeagueShortcut(String leagueShortcut) {
        this.leagueShortcut = leagueShortcut;
    }

    public int getIdTeam1() {
        return idTeam1;
    }

    public void setIdTeam1(int idTeam1) {
        this.idTeam1 = idTeam1;
    }

    public int getIdTeam2() {
        return idTeam2;
    }

    public void setIdTeam2(int idTeam2) {
        this.idTeam2 = idTeam2;
    }

    public int getPointsTeam1() {
        return pointsTeam1;
    }

    public void setPointsTeam1(int pointsTeam1) {
        this.pointsTeam1 = pointsTeam1;
    }

    public int getPointsTeam2() {
        return pointsTeam2;
    }

    public void setPointsTeam2(int pointsTeam2) {
        this.pointsTeam2 = pointsTeam2;
    }

    public boolean isMatchIsFinished() {
        return matchIsFinished;
    }

    public void setMatchIsFinished(boolean matchIsFinished) {
        this.matchIsFinished = matchIsFinished;
    }

    public List<MatchResult> getMatchResults() {
	if (this.matchResults == null){
	    this.matchResults = new LinkedList<MatchResult>();
	}
        return matchResults;
    }

    public void addMatchResult(MatchResult matchResult) {
        getMatchResults().add(matchResult);
    }

    public List<Goal> getGoals() {
	if (this.goals == null){
	    this.goals = new LinkedList<Goal>();
	}
        return goals;
    }

    public void addGoal(Goal goal) {
        getGoals().add(goal);
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getNumberOfViewers() {
        return numberOfViewers;
    }

    public void setNumberOfViewers(int numberOfViewers) {
        this.numberOfViewers = numberOfViewers;
    }
    
    @Override
    public String toString() {
	return "Matchdata [matchID=" + matchID + ", matchDateTime=" + matchDateTime + ", groupID=" + groupID + ", groupOrderID="
		+ groupOrderID + ", groupName=" + groupName + ", leagueID=" + leagueID + ", leagueName=" + leagueName + ", leageSaison="
		+ leageSaison + ", leagueShortcut=" + leagueShortcut + ", idTeam1=" + idTeam1 + ", idTeam2=" + idTeam2 + ", pointsTeam1="
		+ pointsTeam1 + ", pointsTeam2=" + pointsTeam2 + ", matchIsFinished=" + matchIsFinished + ", matchResult=" + matchResults
		+ ", goals=" + goals + ", location=" + location + ", numberOfViewers=" + numberOfViewers + "]";
    }
    
}
