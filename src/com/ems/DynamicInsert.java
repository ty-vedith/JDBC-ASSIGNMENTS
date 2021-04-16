package com.ems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DynamicInsert {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems?user=root&password=root@123");
			
			String query="insert into Employee values(?,?,?,?,?)";
			ps=con.prepareStatement(query);
			
			String eid=args[0];
			int id= Integer.parseInt(eid);
			ps.setInt(1,id);
			
			String ename=args[1];
			ps.setString(2, ename);
			
			String salary=args[2];
			int sal=Integer.parseInt(salary);
			ps.setInt(3, sal);
			
			String Dept= args[3];
			ps.setString(4, Dept);
			
			String Mob=args[4];
			int mob= Integer.parseInt(Mob);
			ps.setInt(5, mob);
			ps.executeUpdate();
			System.out.println("Insertion Successfull..");
			
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
			if(ps!=null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
		

	}

}
