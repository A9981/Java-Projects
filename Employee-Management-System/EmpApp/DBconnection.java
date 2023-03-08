package org.jspiders.EmpApp;

import java.sql.*;

public class DBconnection {
	static Connection con;

	public static Connection createDBConnection() {
		try {
			//load and registered the Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			//get connection
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?user=root & password=admin");
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
}


