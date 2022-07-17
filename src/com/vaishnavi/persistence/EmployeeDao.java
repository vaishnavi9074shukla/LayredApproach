package com.vaishnavi.persistence;
import java.util.Set;

import com.vaishnavi.bean.Employee;
public interface EmployeeDao {
	boolean addRecord(Employee employee);
	boolean deleteRecord(int empId);
	Employee searchRecord(int empId);
	Set<Employee> getAllRecords();
}
