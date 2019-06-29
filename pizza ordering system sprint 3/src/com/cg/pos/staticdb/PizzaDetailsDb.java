package com.cg.pos.staticdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PizzaDetailsDb {
	public void connection(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","system","system");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select name from employee where id=101");  
			while(rs.next())  
			System.out.println(rs.getString(1));  
			con.close();  
			}catch(Exception e){ System.err.println(e);}  
			}  
	}