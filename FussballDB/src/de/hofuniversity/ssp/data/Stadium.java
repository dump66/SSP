package de.hofuniversity.ssp.data;

public class Stadium {

    private int	   id;
    private String name;
    private String gps;
    private String address;
    private String picture;
    private int	   capacity;

    public Stadium() {

    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
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

    public String getPicture() {
	return picture;
    }

    public void setPicture(String picture) {
	this.picture = picture;
    }

    public int getCapacity() {
	return capacity;
    }

    public void setCapacity(int capacity) {
	this.capacity = capacity;
    }

    @Override
    public String toString() {
	return "Stadium [id=" + id + ", name=" + name + ", gps=" + gps + ", address=" + address + ", picture=" + picture + ", capacity="
		+ capacity + "]";
    }

}
