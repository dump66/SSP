package de.hofuniversity.ssp.sax;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class BookstoreParser extends DefaultHandler {

    public static final int DEFAULT_STATE = 0;
    public static final int BOOK_STATE	  = 1;
    public static final int TITLE_STATE	  = 2;
    public static final int AUTHOR_STATE  = 3;
    public static final int YEAR_STATE	  = 4;
    public static final int PRICE_STATE	  = 5;

    private int		    state	  = DEFAULT_STATE;
    private File	    in;
    private Bookstore	    bookStore;
    private Book	    current;

    public BookstoreParser(File in) {
	this.in = in;
	bookStore = new Bookstore();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	if (qName.equalsIgnoreCase("book")) {
	    current = new Book();
	    current.setCategory(attributes.getValue("category"));
	    state = BOOK_STATE;
	} else if (qName.equalsIgnoreCase("title")) {
	    Title t = new Title();
	    t.setLang(attributes.getValue("lang"));
	    current.setTitle(t);
	    state = TITLE_STATE;
	} else if (qName.equalsIgnoreCase("year")) {
	    state = YEAR_STATE;
	} else {
	    state = DEFAULT_STATE;
	}
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
	String text = new String(ch, start, length);
	switch (state) {
	case TITLE_STATE:
	    current.getTitle().setText(text);
	    break;
	case YEAR_STATE:
	    current.setYear(new Integer(text));
	    break;
	default:
	    break;
	}
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
	if (qName.equalsIgnoreCase("book")){
	    bookStore.addBook(current);
	    current = null;
	    state = DEFAULT_STATE;
	}
    }
    
    public Bookstore parse() throws FileNotFoundException, IOException, SAXException {
	XMLReader r = XMLReaderFactory.createXMLReader();
	r.setContentHandler(this);
	r.parse(new InputSource(new FileReader(in)));
	
	return bookStore;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, SAXException {
	BookstoreParser p = new BookstoreParser(new File("books.xml"));
	for (Book b : p.parse().getBooks()){
	    System.out.println(b);
	}
    }

}
