package com.ems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StaticSelect {
	
	
	public static void main(String[] args) {
		Connection con=null;
		Statement stmt= null;
		ResultSet res=null;
	try {
		//step-1
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	    //step-2
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root@123");
		
		//step-3
		String Query="select * from Employee";
		stmt=con.createStatement();
		res=stmt.executeQuery(Query);
		
		//step-4
		while(res.next()) {
			System.out.println(res.getInt("id"));
			System.out.println(res.getString("name"));
			System.out.println(res.getInt("sal"));
			System.out.println(res.getString("dept"));
			System.out.println(res.getInt("ph_no"));
			System.out.println("-----------------------");
			
			
		}
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		//step-5
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(stmt!=null)
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(res!=null) {
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
		
	}

		
	
	
	}


