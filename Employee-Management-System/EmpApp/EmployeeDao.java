package org.jspiders.EmpApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class EmployeeDao implements EmployeeDaointrf {
	static Connection con;
	static PreparedStatement pstmt = null;
	@Override
	public void createEmployee(Employee emp) {
		con = DBconnection.createDBConnection();
		String qry = "insert into employeedb values(?,?,?,?)";
		try {
			pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, emp.getId());
			pstmt.setString(2, emp.getName());
			pstmt.setDouble(3, emp.getSalary());
			pstmt.setInt(4, emp.getAge());
			int rs = pstmt.executeUpdate();
			if (rs != 0) {
				System.out.println("Employee details inserted successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void showAllEmployee() {
		// TODO Auto-generated method stub
		con = DBconnection.createDBConnection();
		String qry="Select * from employeedb";
		try {
			Statement stmt=con.createStatement();
			ResultSet result=stmt.executeQuery(qry);
			System.out.println("--------------Employee details---------------");
			while(result.next())
			{
				System.out.println("Id     Name    Salary     Age ");
				System.out.println("---------------------------------------------");
				System.out.format("%d\t%s\t%f\t%d\n",result.getInt(1)
						,result.getString(2),result.getDouble(3),result.getInt(4));
				System.out.println("---------------------------------------------");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		

	}

	@Override
	public void showEmployeeBasedOnID(int id) {
		// TODO Auto-generated method stub
		con=DBconnection.createDBConnection();
		String qry="Select * from employeedb where id="+id;
		try {
			Statement stmt=con.createStatement();
			ResultSet result =stmt.executeQuery(qry);
			while(result.next())
			{
				System.out.println("Id     Name    Salary     Age ");
				System.out.println("---------------------------------------------");
				System.out.format("%d\t%s\t%f\t%d\n",result.getInt(1)
						,result.getString(2),result.getDouble(3),result.getInt(4));
				System.out.println("---------------------------------------------");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

	@Override
	public void updateEmployee(int id, String name) {
		// TODO Auto-generated method stub
		con=DBconnection.createDBConnection();
		String qry="Update employeedb set name=? where id=?";
		try {
			pstmt=con.prepareStatement(qry);
			pstmt.setString(1, name);
			pstmt.setInt(2, id);
			int cnt=pstmt.executeUpdate();
			if(cnt!=0)
			{
				System.out.println("Details Updated successfully");
			}
			else
				System.out.println("Id does not exist");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		con=DBconnection.createDBConnection();
		String qry="delete from employeedb where id=?";
		try {
			pstmt=con.prepareStatement(qry);
			pstmt.setInt(1, id);
			int cnt=pstmt.executeUpdate();
			if(cnt!=0)
			{
				System.out.println("Employee Deleted Successfully");
			}
			else
				System.out.println("Please enter valid employee id");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}

}
