package de.hofuniversity.ssp.data;

public class Team {

    private int	    id;
    private String  name;
    private String  founding;
    private String  coach;
    private String  president;
    private String  city;
    private String  icon;
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
