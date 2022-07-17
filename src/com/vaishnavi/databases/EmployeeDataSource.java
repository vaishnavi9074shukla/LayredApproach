package com.vaishnavi.databases;


import java.util.HashSet;

import java.util.Set;

import com.vaishnavi.bean.Employee;

public class EmployeeDataSource {
	private static Set<Employee> employeeList=new HashSet<Employee>();
	static {
		employeeList.add(new Employee(101, "AAAA", "Associate", "IT", 35000));
		employeeList.add(new Employee(1102, "BBBBB", "Executive", "Sales", 15000));
		employeeList.add(new Employee(1103, "CCCC", "Manager", "Sales", 95000));
		employeeList.add(new Employee(1104, "DDDD", "Sr. Manager", "IT", 175000));
		employeeList.add(new Employee(1105, "EEEE", " Manager", "OTT", 1758900));
		employeeList.add(new Employee(1106, "FFFF", " Manager", "OTT", 1758900));
	}
	public static  Set<Employee> getEmployeeList() {
		return employeeList;
	}
	public static void setEmployeeList(Set<Employee> employeeList) {
		EmployeeDataSource.employeeList = employeeList;
	}
}
