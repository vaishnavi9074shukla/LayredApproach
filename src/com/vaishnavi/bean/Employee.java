package com.vaishnavi.bean;

import java.util.Objects;

public class Employee {

		private int empId;
		private String empName;
		private String empDesignation;
		private String empDepartment;
		private double empSalary;
		
		public Employee() {
			
		}

		public Employee(int empId, String empName, String empDesignation, String empDepartment, double empSalary) {
			super();
			this.empId = empId;
			this.empName = empName;
			this.empDesignation = empDesignation;
			this.empDepartment = empDepartment;
			this.empSalary = empSalary;
		}

		public int getEmpId() {
			return empId;
		}

		public void setEmpId(int empId) {
			this.empId = empId;
		}

		public String getEmpName() {
			return empName;
		}

		public void setEmpName(String empName) {
			this.empName = empName;
		}

		public String getEmpDesignation() {
			return empDesignation;
		}

		public void setEmpDesignation(String empDesignation) {
			this.empDesignation = empDesignation;
		}

		public String getEmpDepartment() {
			return empDepartment;
		}

		public void setEmpDepartment(String empDepartment) {
			this.empDepartment = empDepartment;
		}

		public double getEmpSalary() {
			return empSalary;
		}

		public void setEmpSalary(double empSalary) {
			this.empSalary = empSalary;
		}

		@Override
		public int hashCode() {
			return Objects.hash(empDepartment, empDesignation, empId, empName, empSalary);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Employee other = (Employee) obj;
			return Objects.equals(empDepartment, other.empDepartment)
					&& Objects.equals(empDesignation, other.empDesignation) && empId == other.empId
					&& Objects.equals(empName, other.empName)
					&& Double.doubleToLongBits(empSalary) == Double.doubleToLongBits(other.empSalary);
		}

		@Override
		public String toString() {
			return "Employee [empId=" + empId + ", empName=" + empName + ", empDesignation=" + empDesignation
					+ ", empDepartment=" + empDepartment + ", empSalary=" + empSalary + "]";
		}
		
}
