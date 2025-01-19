package com.jsp.jdbc.JDBC_Demo;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {

	public static void main(String[] args) {

		try {

			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","root");

			Statement st1 =conn.createStatement();
			
			Statement st2 =conn.createStatement(); 
			
			
			int rowInserted = st1.executeUpdate("insert into student values(103,'vivek')");
			
			int rowUpdated = st2.executeUpdate("update student set name='rohit' where id=101");

			if(rowInserted>0)
			{
				System.out.println("Data inserted into DB");

			}else {
				System.out.println("Data not inserted into DB");
			}
			
			if(rowUpdated > 0)
			{
				System.out.println("Data Updated");

			}else {
				System.out.println("Data not Updated");
			}
			conn.close();

		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
