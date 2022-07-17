package com.vaishnavi.service;

import java.util.Set;

import com.vaishnavi.bean.Employee;
import com.vaishnavi.bean.EmployeePayslip;

public interface EmployeeService {
	boolean addRecord(Employee employee);
	boolean deleteRecord(int empId);
	Set<Employee> getAllEmployees();
	Employee searchEmployeeById(int employeeId);
	EmployeePayslip generatePayslip(int employeeId);
	
}
