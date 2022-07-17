package com.vaishnavi.service;

import java.util.Set;

import com.vaishnavi.bean.Employee;
import com.vaishnavi.bean.EmployeePayslip;
import com.vaishnavi.persistence.EmployeeDao;
import com.vaishnavi.persistence.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao=new EmployeeDaoImpl();
	
	@Override
	public Set<Employee> getAllEmployees() {
		return employeeDao.getAllRecords();
	}

	@Override
	public Employee searchEmployeeById(int employeeId) {
		return employeeDao.searchRecord(employeeId);
	}

	@Override
	public EmployeePayslip generatePayslip(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}


@Override
public boolean deleteRecord(int empId) {
	return employeeDao.deleteRecord(empId);
}

@Override
public boolean addRecord(Employee employee) {
	return employeeDao.addRecord(employee);
}

}
