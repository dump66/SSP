package de.hofuniversity.ssp.data;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name="verein")
public class Team implements Serializable{

    @Id
    @GeneratedValue
    @Column(name="i_id")
    private int	    id;
    @Column(name="v_name")
    private String  name;
    @Column(name="v_gruendung")
    private String  founding;
    @Column(name="v_trainer")
    private String  coach;
    @Column(name="v_praesident")
    private String  president;
    @Column(name="v_ort")
    private String  city;
    @Column(name="v_logo")
    private String  icon;
    @OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="fk_stadion")
    private Stadium stadium;

    public Team() {

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

    public String getFounding() {
	return founding;
    }

    public void setFounding(String founding) {
	this.founding = founding;
    }

    public String getCoach() {
	return coach;
    }

    public void setCoach(String coach) {
	this.coach = coach;
    }

    public String getPresident() {
	return president;
    }

    public void setPresident(String president) {
	this.president = president;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getIcon() {
	return icon;
    }

    public void setIcon(String icon) {
	this.icon = icon;
    }

    public Stadium getStadium() {
	return stadium;
    }

    public void setStadium(Stadium stadium) {
	this.stadium = stadium;
    }

    @Override
    public String toString() {
	return "Team [id=" + id + ", name=" + name + ", founding=" + founding + ", coach=" + coach + ", president=" + president + ", city="
		+ city + ", icon=" + icon + ", stadium=" + stadium + "]";
    }

}
