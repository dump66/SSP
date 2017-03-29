package de.hofuniversity.ssp.sax;

import java.util.LinkedList;
import java.util.List;

public class Bookstore {

    private List<Book> books;
    
    public Bookstore(){
	
    }

    public List<Book> getBooks() {
	if (this.books == null){
	    books = new LinkedList<Book>();
	}
        return books;
    }

    public void addBook(Book book) {
        getBooks().add(book);
    }
    
    @Override
    public String toString() {
	// TODO
        return super.toString();
    }
    
}