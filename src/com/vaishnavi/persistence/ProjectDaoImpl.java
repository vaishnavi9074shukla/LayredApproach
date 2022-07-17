package com.vaishnavi.persistence;


import java.util.*;

import com.vaishnavi.bean.Employee;
import com.vaishnavi.bean.Project;
import com.vaishnavi.databases.ProjectDataSource;
import com.vaishnavi.databases.ProjectEmployeeDataSource;

public class ProjectDaoImpl implements ProjectDao {
	
	EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();


	@Override
	public Set <Project> getAllRecords() {
			return ProjectDataSource.getProjectList();
		}
	
	@Override
	public Project searchProject(int proId) {
		Set<Project> projects=ProjectDataSource.getProjectList();
		for(Project p:projects) {
			if(p.getProjectId()==proId)
				return p;
		}
		return null;
	}

	@Override
	public boolean addProject(Project project) {
		Set <Project> projects = ProjectDataSource.getProjectList();
		projects.add(project);
		ProjectDataSource.setProjectList(projects);
		return true;
	}

	@Override
	public boolean deleteProject(int projectId) {
		if(searchProject(projectId) != null) {
			Set <Project> projects = ProjectDataSource.getProjectList();
			for(Project p:projects) {
				if(p.getProjectId()==projectId) {
					projects.remove(p);
					ProjectDataSource.setProjectList(projects);
					break;
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean allocateProject(int empId, int projId) {
		Employee employee = employeeDaoImpl.searchRecord(empId);
		Project project = searchProject(projId);
		if( employee != null && project != null) {
			return addEmpToProject(project, employee);
		}
		return false;
	}
	
	
	Map<Project, Set<Employee>> getAllEmpAndProject=ProjectEmployeeDataSource.getEmpAndProject();
	@Override
	public Map<Project, Set<Employee>> getALlAllocatedEmployee() {
		return getAllEmpAndProject;
	}

	@Override
	public boolean addEmpToProject(Project proj, Employee emp) {
		Project currentProject = getAllocatedProject(emp);
		if(currentProject == null) {
			Set<Employee> empProj = getAllEmpAndProject.get(proj);
			if(empProj.size()<10) {
				empProj.add(emp);
				ProjectEmployeeDataSource.setEmpInProject(getAllEmpAndProject);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean removeEmpFromProject(Project assignedProj, Employee emp) {
		Set<Employee> empSet = getAllEmpAndProject.get(assignedProj);
		if(empSet.contains(emp)) {
			empSet.remove(emp);
			ProjectEmployeeDataSource.setEmpInProject(getAllEmpAndProject);
			return true;
		}
		return false;
	}

	@Override
	public Set<Employee> getEmployeeInProject(int projId) {
		for(Project proj:getALlAllocatedEmployee().keySet()) {
			if(proj.getProjectId()==projId) {
				return getAllEmpAndProject.get(proj);
			}
		}
		return null;
	}

	@Override
	public boolean shiftEmployeeToDifferentProject(Project proj, Employee emp) {
		Project project = getAllocatedProject(emp);
		if(removeEmpFromProject(project, emp)) 
		{
			if(addEmpToProject(proj, emp)) {
				return true;
			}
			else {
				addEmpToProject(project, emp);
				return false;
			}
		}
		return false;
	}

	@Override
	public Project getAllocatedProject(Employee emp) {
		for(Project proj:getAllEmpAndProject.keySet()) {
			if(getAllEmpAndProject.get(proj).contains(emp)) {
				return proj;
			}
		}
		return null;
	}

	@Override
	public boolean deAllocateProject(int empId, int projId) {
		Employee emp = employeeDaoImpl.searchRecord(empId);
		Project proj = searchProject(projId);
		if(emp != null && proj!= null) {
			return removeEmpFromProject(proj, emp);
		}
		return false;
	}

	@Override
	public boolean shiftToProject(int empId, int projId) {
		Employee emp = employeeDaoImpl.searchRecord(empId);
		Project proj = searchProject(projId);
		if(emp != null && proj!= null) {
			return shiftEmployeeToDifferentProject(proj, emp);
		}
		return false;
	}

	}


