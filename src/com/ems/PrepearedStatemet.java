package com.ems;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.PreparableStatement;


public class PrepearedStatemet {   //USING COMMAND LINE ARGUMENTS
	

		public static void main(String[] args) {
			Connection con=null;
			PreparedStatement psmt=null;
			ResultSet res=null;
			
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root", "root@123");
				
				String query="select * from Employee where id=?";
				psmt=con.prepareStatement(query);
				
				//reading the parameter through command line argument
				String eid= args[0];
				int employeeid=Integer.parseInt(eid);
				
				//binding the parameters for employee id
				
				psmt.setInt(1, employeeid);
				res= psmt.executeQuery();
				
				//process the results returned by SQL query
				if(res.next()) {
					int empid=res.getInt("id");
					String empname =res.getString("name");
					int sal=res.getInt("sal");
					String dept= res.getString("dept");
					int ph=res.getInt("ph_no");
					
					///print
					
					System.out.println("Employee id= "+empid);
					System.out.println("Employee name= "+empname);
					System.out.println("Employee id= "+sal);
					System.out.println("Employee id= "+dept);
					System.out.println("Employee id= "+ph);
					
					
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
				if(psmt!=null)
					try {
						psmt.close();
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
