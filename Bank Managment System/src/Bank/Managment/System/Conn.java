package Bank.Managment.System;

import java.sql.*;

public class Conn {
	
	Connection connection;
	
	String url = "Url";
	String user = "Username";
	String pass = "Password";

	Statement statement;
	
	
	public Conn() {
		
		try {
			
			 connection = DriverManager.getConnection(url, user, pass);
			 
			 statement = connection.createStatement();
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
