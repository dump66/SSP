package de.hofuniversity.ssp.data;

import java.net.MalformedURLException;
import java.net.URL;

public class Stadium {

    private String name;
    private String gps;
    private String address;
    private URL picture;
    private int capacity;
    
    public Stadium(){
	
    }
    
    public Stadium(String name){
	this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public URL getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        try {
	    this.picture = new URL(picture);
	} catch (MalformedURLException e) {
	    System.out.println("Warning: Could not create URL. Check XML File. URL-String:" + System.lineSeparator() + picture);
	}
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    
}
