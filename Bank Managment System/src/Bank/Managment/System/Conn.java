package Bank.Managment.System;

import java.sql.*;

public class Conn {
	
	Connection connection;
	
	String url = "jdbc:mysql://localhost:3306/bankSystem";
	String user = "root";
	String pass = "Mysql";

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
