package com.cg.pos.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	static Connection con=null;
	
	public static Connection getConnection() {
		if(con==null)
		{
		
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
	    } catch (SQLException ex) {
	        throw new RuntimeException("Error connecting to the database", ex);
	    }
		}
		return con;

}
}
