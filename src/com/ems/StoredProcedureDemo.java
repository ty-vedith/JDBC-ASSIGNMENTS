package com.ems;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StoredProcedureDemo {

	public static void main(String[] args) {
		Connection con=null;
		CallableStatement cst=null;
		ResultSet res=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			

			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root@123");
		    cst=con.prepareCall("call pro(2)");
		    
		    res=cst.executeQuery();
			
			while(res.next()) {
				System.out.println(res.getInt("id"));
				System.out.println(res.getString("name"));
				System.out.println(res.getInt("sal"));
				System.out.println(res.getString("sal"));
				System.out.println(res.getInt("ph_no"));
				
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(con!=null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(cst!=null)
				try {
					cst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		

	}

}
