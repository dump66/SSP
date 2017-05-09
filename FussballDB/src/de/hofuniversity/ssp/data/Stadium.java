package de.hofuniversity.ssp.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="stadion")
public class Stadium implements Serializable{
    
    private static int idCounter = 1;

    @Id
    @GeneratedValue
    @Column(name="i_id")
    private int	   id;
    @Column(name="v_name")
    private String name;
    @Column(name="v_gps")
    private String gps;
    @Column(name="v_adresse")
    private String address;
    @Column(name="v_bild")
    private String picture;
    @Column(name="i_kapazitaet")
    private int	   capacity;

    public Stadium() {
	this.id = idCounter++;
    }

    public int getId() {
	return id;
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
