package com.ems;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Logger;

public class StaticInsert {

	public static void main(String[] args) {
		Connection con=null;
		Statement stmt=null;
		
		try {
			
			//step-1
			// FIRST WAY TO LOAD THE DRIVER  --->> PREFERED
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			// SECOND WAY TO LOAD THE DRIER
//			Driver driver= new com.mysql.cj.jdbc.Driver();
//			DriverManager.registerDriver(driver);
//			
			//step-2
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root@123");
			
			//step-3
			String query="insert into employee values(3,'RAHUL',200000,'TEST',888040)";
			stmt=con.createStatement();
			
			
			
			//step-4
			int count=stmt.executeUpdate(query);
			System.out.println("No of rows Affected: "+ count);
			
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

		}
		
		
		
	
		
		

	}
}
	
	