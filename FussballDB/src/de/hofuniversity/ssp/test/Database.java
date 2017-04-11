package de.hofuniversity.ssp.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {

    public Connection getConnection() throws Exception {
	Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
	DriverManager.registerDriver(driver);
	// Hier eventuell den Datenbank-Namen anpassen
	Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fussballdb", "Student", "Hof");
	return c;
    }

    private void executeStatement(String sql) throws Exception {
	Statement stmt = (Statement) getConnection().createStatement();
	if (sql.contains(";")) {
	    String[] ssql = sql.split("[;]");
	    for (String s : ssql) {
		stmt.execute(s.endsWith(";") ? s.substring(0, s.length()-1) : s);
	    }
	} else {
	    stmt.execute(sql);
	}
	stmt.close();
    }

    private String getDDL(String name) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(name)));
	String line, sql = "";
	while ((line = br.readLine()) != null) {
	    sql += line;
	}
	br.close();
	return sql;
    }

    public static void main(String[] args) throws Exception {
	Database db = new Database();
	db.executeStatement(db.getDDL("team.sql"));
    }
}
