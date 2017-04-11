package de.hofuniversity.ssp.data;

public class Player {

    private int playerID;
    private String name;
    
    public Player() {
	this.playerID = -1;
    }
    
    public Player(String name){
	this();
	this.name = name;
    }
    
    public int getPlayerID() {
	return playerID;
    }

    public void setPlayerID(int playerID) {
	this.playerID = playerID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return getName();
    }
}
