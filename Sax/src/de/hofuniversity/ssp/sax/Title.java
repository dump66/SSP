package de.hofuniversity.ssp.sax;

public class Title {

    private String title, lang;
    
    public Title(){
	
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
    
    @Override
    public String toString() {
        return getLang() + ": " + getTitle();
    }
}
