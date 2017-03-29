package de.hofuniversity.ssp.sax;

public class Title {

    private String text, lang;

    public Title() {

    }

    public String getText() {
	return text;
    }

    public void setText(String text) {
	this.text = text;
    }

    public String getLang() {
	return lang;
    }

    public void setLang(String lang) {
	this.lang = lang;
    }

    @Override
    public String toString() {
	return getText() + ":" + getLang();
    }
}
