package com.vaishnavi.service;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import com.vaishnavi.bean.Employee;
import com.vaishnavi.bean.Project;

public interface ProjectService {
	Set<Project> getAllProjects();
	Project searchProjectById(int projId);
	boolean addNewProject(Project project);
	boolean deleteProject(int projId);
	
	Map<Project, Set<Employee>> getAllEmpInProject();
	boolean allocateProject(int empId, int projId);
	boolean deAllocateProject(int empId, int projId);
	boolean shiftToAnotherProject(int empId, int projId);
}
