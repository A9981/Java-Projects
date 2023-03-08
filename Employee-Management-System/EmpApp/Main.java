package org.jspiders.EmpApp;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to employee management Application");
		Scanner sc=new Scanner(System.in);
		EmployeeDaointrf dao=new EmployeeDao();
		
		do {
			System.out.println("1. Add employee\n"+
		                       "2. Show All Employee\n"+
					           "3. Show Employee Based on id\n"+
					           "4. Update the employee\n"+
					           "5. Delete the employee\n");
			System.out.println("Enter choice: ");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:
				Employee emp=new Employee();
				System.out.println("Enter id:");
				int id=sc.nextInt();
				System.out.println("Enter name: ");
				String name=sc.next();
				System.out.println("Enter salary:");
				double salary=sc.nextDouble();
				System.out.println("enter age");
				int age=sc.nextInt();
				emp.setId(id);
				emp.setName(name);
				emp.setSalary(salary);
				emp.setAge(age);
				dao.createEmployee(emp);
				break;
			case 2:
				dao.showAllEmployee();
				break;
			case 3:
				System.out.println("Insert the id of employee");
				int sid=sc.nextInt();
				dao.showEmployeeBasedOnID(sid);
				break;
			case 4:
				System.out.println("Enter id to update details");
				int empid=sc.nextInt();
				System.out.println("enter the new name");
				name=sc.next();
				dao.updateEmployee(empid, name);
				break;
			case 5:
				System.out.println("enter id to delete the record");
				empid=sc.nextInt();
				dao.deleteEmployee(empid);
				break;
				
			case 6:
				System.out.println("Thank you for using our application ");
				break;
			default:
				System.out.println("Enter valid choice");
				break;
				
				
			}
		}
		while(true);
			

	}

}
