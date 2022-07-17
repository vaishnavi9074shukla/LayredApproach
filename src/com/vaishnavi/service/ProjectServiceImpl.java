package com.vaishnavi.service;


import java.util.*;

import com.vaishnavi.bean.Employee;
import com.vaishnavi.bean.Project;

import com.vaishnavi.persistence.ProjectDao;
import com.vaishnavi.persistence.ProjectDaoImpl;

public class ProjectServiceImpl implements ProjectService{

	private ProjectDaoImpl projectDao=new ProjectDaoImpl();

	@Override
	public Set<Project> getAllProjects() {
		return projectDao.getAllRecords();
	}

	@Override
	public Project searchProjectById(int projId) {
		return projectDao.searchProject(projId);
	}

	@Override
	public boolean addNewProject(Project project) {
		return projectDao.addProject(project);
	}

	@Override
	public boolean deleteProject(int projId) {
		return projectDao.deleteProject(projId);
	}

	@Override
	public Map<Project, Set<Employee>> getAllEmpInProject() {
		return projectDao.getALlAllocatedEmployee();
	}

	@Override
	public boolean allocateProject(int empId, int projId) {
		return projectDao.allocateProject(empId, projId);
	}

	@Override
	public boolean deAllocateProject(int empId, int projId) {
		return projectDao.deAllocateProject(empId, projId);
	}

	@Override
	public boolean shiftToAnotherProject(int empId, int projId) {
		return projectDao.shiftToProject(empId, projId);
	}

}
