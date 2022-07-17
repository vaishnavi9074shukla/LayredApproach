package com.vaishnavi.persistence;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import com.vaishnavi.bean.Employee;
import com.vaishnavi.bean.Project;


public interface ProjectDao {
	Set<Project> getAllRecords();
	boolean addProject(Project project);
	boolean deleteProject(int projectId);
	Project searchProject(int proId);
	
	boolean allocateProject(int empId, int projId);
	boolean deAllocateProject(int empId, int projId);
	boolean shiftToProject(int empId, int projId);
	
	Map<Project, Set<Employee>> getALlAllocatedEmployee();
	boolean addEmpToProject(Project proj, Employee emp);
	boolean removeEmpFromProject(Project assignedProj, Employee emp);
	Set<Employee>getEmployeeInProject(int projId);
	boolean shiftEmployeeToDifferentProject(Project proj, Employee emp);
	Project getAllocatedProject(Employee emp);
	
}
