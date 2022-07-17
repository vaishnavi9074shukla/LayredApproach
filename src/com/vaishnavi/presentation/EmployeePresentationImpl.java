package com.vaishnavi.presentation;

import java.util.*;

import com.vaishnavi.bean.Employee;
import com.vaishnavi.bean.Project;
import com.vaishnavi.service.EmployeeService;
import com.vaishnavi.service.EmployeeServiceImpl;
import com.vaishnavi.service.ProjectService;
import com.vaishnavi.service.ProjectServiceImpl;

public class EmployeePresentationImpl implements EmployeePresentation {

	private EmployeeService employeeService=new EmployeeServiceImpl();
	private ProjectService projectService = new ProjectServiceImpl();

	
	@Override
	public void showMenu() {
		System.out.println("1. Show All Employees");
		System.out.println("2. Search Employee By ID");
		System.out.println("3. Add Employee");
		System.out.println("4. Remove Employee");
		System.out.println("=======================");
		System.out.println("5. Show All Projects");
		System.out.println("6. Search Project By Id");
		System.out.println("7. Add New Project");
		System.out.println("8. Delete Project");
		System.out.println("=======================");
		System.out.println("9. Show Employees With Projects");
		System.out.println("10. Allocate a Project to an Employee");
		System.out.println("11. Deallocate the project");
		System.out.println("12. Allocate to different project");
		System.out.println("13. Exit");

	}

	@Override
	public void performMenu(int choice) {
		try (Scanner scanner = new Scanner(System.in)) {
			switch (choice) {
			case 1:
				Set<Employee> employees=employeeService.getAllEmployees();
				for(Employee employee:employees) {
					System.out.println(employee.getEmpId()+"  "+employee.getEmpName());
				}
				break;

			case 2:
				System.out.println("Enter Employee ID : ");
				int id=scanner.nextInt();
				Employee empl=employeeService.searchEmployeeById(id);
				if(empl!=null) {
					System.out.println(empl.getEmpId()+"  "+empl.getEmpName());
				}
				else
					System.out.println("Employee with id "+id+" does not exist");
				break;
			case 3:
				System.out.println("Enter Employee ID : ");
				int idOfEmployee = scanner.nextInt();
				System.out.println("Enter Employee Name : ");
				String empName = scanner.next();
				System.out.println("Enter Employee Designation : ");
				String empDesignation= scanner.next();
				System.out.println("Enter Employee Department : ");
				String empDepartment = scanner.next();
				System.out.println("Enter Employee Salary : ");
				double empSalary = scanner.nextDouble();
				boolean flag = employeeService.addRecord(new Employee(idOfEmployee,empName,
						empDesignation,empDepartment,empSalary));
				if(flag == true)
					System.out.println("Record Added Successfully");
				else
					System.out.println("Something Wrong Try Again");
				
				break;
			case 4:
				System.out.println("Enter Id to delete record");
				int empId = scanner.nextInt();
				boolean employee = employeeService.deleteRecord(empId);
				if(employee==true)
					System.out.println("SuccessFully Deleted");
				else
					System.out.println("Employee is not present in the database, check and try again");
			break;
			case 5:
				Set<Project> projects = projectService .getAllProjects();
				for(Project p: projects) {
					System.out.println(p.getProjectId()+" "+p.getProjectName());
				}
				break;
			case 6:
				System.out.println("Enter Project Id : ");
				int idEmployee = scanner.nextInt();
				Project proj = projectService.searchProjectById(idEmployee);
				if(proj != null) {
					System.out.println(proj.getProjectId()+" "+proj.getProjectName());
				}
				else
					System.out.println("Project with "+ idEmployee +" does not present");
				break;
			case 7:
				System.out.println("Enter Project Id : ");
				int projId = scanner.nextInt();
				System.out.println("Enter Project Name : ");
				String projName = scanner.nextLine();
				boolean project = projectService.addNewProject(new Project(projId, projName));
				if(project != false) {
					System.out.println("Project Added Successfully");
				}
				else
					System.out.println("Unable to add the project");
				break;
			case 8:
				System.out.println("Enter Project Id to Delete: ");
				int projd = scanner.nextInt();
				boolean projToDelete = projectService.deleteProject(projd);
				if(projToDelete != false) {
					System.out.println("Successfully Deleted");
				}
				else
					System.out.println("Unable to delete the project");
				break;
			case 9:
				System.out.println("Allocated Projects and Employee List");
				Map<Project,Set<Employee>> empAndProject = projectService.getAllEmpInProject();
				for(Project p: empAndProject.keySet()) {
					System.out.println(p+ " "+empAndProject.get(p));
				}
				break;
			case 10:
				System.out.println("Enter Employee Id : ");
				int employeeId = scanner.nextInt();
				System.out.println("Enter Project Id : ");
				int idOfProject = scanner.nextInt();
				if(projectService.allocateProject(employeeId, idOfProject)) {
					System.out.println("Project Allocated Successfully");
				}
				else
					System.out.println("Unable to Allocate the project");
				break;
			case 11:
				System.out.println("Enter Employee Id : ");
				int employId = scanner.nextInt();
				System.out.println("Enter Project Id : ");
				int idOfProj = scanner.nextInt();
				if(projectService.deAllocateProject(employId, idOfProj)) {
					System.out.println("Project Deallocated Successfully");
				}
				else
					System.out.println("Unable to Deallocate the project");
				break;
			case 12:
				System.out.println("Enter Employee Id : ");
				int emplId = scanner.nextInt();
				System.out.println("Enter Project Id : ");
				int idProject = scanner.nextInt();
				if(projectService.shiftToAnotherProject(emplId, idProject)) {
					System.out.println("Employee Allocated to another project Successfully");
				}
				else
					System.out.println("Unable to Allocate the employee to another project");
				break;
			case 13:
				System.out.println("Thanks for using Employee Management System");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Coice");
				break;
			}
		}
			catch(Exception exception) {
				
			}
		}
	


}
