package de.hofuniversity.ssp.sax;

import java.util.LinkedList;
import java.util.List;

public class Book {

    private String category;
    private Title title;
    private List<String> authors;
    private int year;
    private double price;
    
    public Book(){
	
    }
    
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public Title getTitle() {
        return title;
    }
    public void setTitle(Title title) {
        this.title = title;
    }
    public List<String> getAuthors() {
	if (this.authors == null){
	    this.authors = new LinkedList<String>();
	}
        return authors;
    }
    public void addAuthor(String author) {
	getAuthors().add(author);
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return getYear() + ": " + getPrice();
    }
}
