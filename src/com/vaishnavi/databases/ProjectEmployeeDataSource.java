package com.vaishnavi.databases;

import java.util.*;


import com.vaishnavi.bean.Employee;
import com.vaishnavi.bean.Project;

public class ProjectEmployeeDataSource {
	
	private static Map<Project, Set<Employee>> projectAndEmployee = new HashMap<Project,Set<Employee>>();
	
	static Set<Project> proj = ProjectDataSource.getProjectList();
	static List<Project> projectList = new ArrayList<Project>(proj);
	
	static Set<Employee> employee =  EmployeeDataSource.getEmployeeList();
	static List<Employee> employeeList = new ArrayList<Employee>(employee);
	
	static {
		Set<Employee> employee = new HashSet<Employee>();
		employee.add(employeeList.get(0));
		employee.add(employeeList.get(1));
		employee.add(employeeList.get(2));
		projectAndEmployee.put(projectList.get(0), employee);
		
		employee = new HashSet<Employee>();
		employee.add(employeeList.get(3));
		employee.add(employeeList.get(4));
		employee.add(employeeList.get(5));
		projectAndEmployee.put(projectList.get(1), employee);
	}
	public static Map<Project,Set<Employee>> getEmpAndProject(){
		return projectAndEmployee;
	}
	public static void setEmpInProject(Map<Project,Set<Employee>> projectAndEmployee) {
		ProjectEmployeeDataSource.projectAndEmployee=projectAndEmployee;
	}
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

