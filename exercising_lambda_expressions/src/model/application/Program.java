package model.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Stream;

import model.entities.Employee;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		System.out.print("Enter full file path: ");
		String path = sc.nextLine();
		System.out.print("Enter salary: ");
		double salary = sc.nextDouble();
		
		List<Employee> employees = new ArrayList<Employee>(); 
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
				
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				employees.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
				line = br.readLine();
			}
			
			Stream<Employee> emp = employees.stream()
					.filter(x -> x.getSalary() >= salary)
					.sorted((e1, e2) -> e1.getEmail().toUpperCase().compareTo(e2.getEmail().toUpperCase()));
			
			
			double sumSalary = employees.stream()
					.filter(x -> x.getName().charAt(0) == 'M')
					.map(x -> x.getSalary())
					.reduce(0.0, (x,y) -> x + y);
			
			System.out.println("Email of people whose salary is more than " + String.format("%.2f", salary));
			emp.forEach(System.out::println);
			System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sumSalary));
			
			
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}catch (RuntimeException e) {
			// TODO: handle exception
		}
		sc.close();
	}

}
