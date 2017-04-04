package de.hofuniversity.ssp.matches;

public class Location {

    private int locationID;
    private String locationCity;
    private String locationStadium;
    
    public Location(){
	
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getLocationStadium() {
        return locationStadium;
    }

    public void setLocationStadium(String locationStadium) {
        this.locationStadium = locationStadium;
    }

    @Override
    public String toString() {
	return "Location [locationID=" + locationID + ", locationCity=" + locationCity + ", locationStadium=" + locationStadium + "]";
    }
    
    
}
