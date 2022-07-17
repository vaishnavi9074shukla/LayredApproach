package com.vaishnavi.persistence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.vaishnavi.bean.Employee;
import com.vaishnavi.databases.EmployeeDataSource;

public class EmployeeDaoImpl implements EmployeeDao {

	
	@Override
	public boolean addRecord(Employee employee) {
		Set<Employee> employees=EmployeeDataSource.getEmployeeList();
		employees.add(employee);
		EmployeeDataSource.setEmployeeList(employees);
				return true;
	}

	@Override
	public boolean deleteRecord(int empId) {
		if(searchRecord(empId)!=null) {
			Set<Employee>employees = EmployeeDataSource.getEmployeeList();
			for(Employee e:employees) {
				if(e.getEmpId() == empId) {
					employees.remove(e);
					EmployeeDataSource.setEmployeeList(employees);
					break;
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public Employee searchRecord(int empId) {
		Set<Employee> employees=EmployeeDataSource.getEmployeeList();
		for(Employee e:employees) {
			if(e.getEmpId() == empId)
				return e;
		}
		return null;
	}

	@Override
	public Set<Employee> getAllRecords() {
		return EmployeeDataSource.getEmployeeList();
	}

}
