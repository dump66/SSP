package de.hofuniversity.ssp.data;

public class MatchResult {

    private String resultName;
    private int pointsTeam1;
    private int pointsTeam2;
    private int resultOrderID;
    private String resultTypeName;
    private int resultTypeID;
    
    public MatchResult() {

    }

    public String getResultName() {
        return resultName;
    }

    public void setResultName(String resultName) {
        this.resultName = resultName;
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

    public int getResultOrderID() {
        return resultOrderID;
    }

    public void setResultOrderID(int resultOrderID) {
        this.resultOrderID = resultOrderID;
    }

    public String getResultTypeName() {
        return resultTypeName;
    }

    public void setResultTypeName(String resultTypeName) {
        this.resultTypeName = resultTypeName;
    }

    public int getResultTypeID() {
        return resultTypeID;
    }

    public void setResultTypeID(int resultTypeID) {
        this.resultTypeID = resultTypeID;
    }

    @Override
    public String toString() {
	return "MatchResult [resultName=" + resultName + ", pointsTeam1=" + pointsTeam1 + ", pointsTeam2=" + pointsTeam2
		+ ", resultOrderID=" + resultOrderID + ", resultTypeName=" + resultTypeName + ", resultTypeID=" + resultTypeID + "]";
    }
    
    
}
