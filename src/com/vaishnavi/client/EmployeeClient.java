package com.vaishnavi.client;

import java.util.Scanner;

import com.vaishnavi.presentation.EmployeePresentation;
import com.vaishnavi.presentation.EmployeePresentationImpl;

public class EmployeeClient {
	public static void main(String[] args) {
		EmployeePresentation employeePresentation=new EmployeePresentationImpl();
		Scanner scanner = new Scanner(System.in);
		
			while(true) {
				employeePresentation.showMenu();
				System.out.println("Enter Choice ");
				int choice=scanner.nextInt();
				employeePresentation.performMenu(choice);
					
			}
		}

}