package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Employee> employees = new ArrayList<Employee>();
		System.out.print("Enter the number of employees: ");
		int n = sc.nextInt();
		sc.nextLine();
		for(int i =0; i < n; i++) {
			System.out.println("Employye #"+ (i+1)+ " data:");
					
			System.out.print("Outsourced (y/n)? ");
			String answer = sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Hour: ");
			int hours = sc.nextInt();
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			sc.nextLine();
			
			if(answer.equalsIgnoreCase("y")) {
				System.out.print("Additional Charge: ");
				double additionalCharge = sc.nextDouble();
				sc.nextLine();
				Employee employee =  new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
				employees.add(employee);
			}else {
				Employee employee = new Employee(name, hours, valuePerHour);
				employees.add(employee);
			}
		}
		
		for(Employee employe : employees) {
			System.out.println(employe);
		}
		sc.close();
		
	}
}
