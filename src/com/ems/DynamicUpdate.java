package com.ems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;

public class DynamicUpdate {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement psmt=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root@123");
			
			String query="update employee set name=? where id=?";
			psmt=con.prepareStatement(query);
			
			//binding parameter 
			psmt.setString(1, "RAHUL");
			psmt.setInt(2, 3);
			int count= psmt.executeUpdate();
			System.out.println("Update successfull");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (SQLException e) {
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
			if(psmt!=null)
				try {
					psmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
		
	

	}

}
