package apllication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.JuridicPerson;
import entities.Person;
import entities.PhysicsPerson;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Person> persons = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i =0; i < n; i++ ) {
			System.out.println("Tax payer #" +(1 + i)+" data:");
			System.out.print("Individual or company (i/c)? ");
			char chr = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();
			
			if(chr == 'i') {
				System.out.print("Health expenditures: ");
				double healthCost = sc.nextDouble();
				persons.add(new PhysicsPerson(name, anualIncome, healthCost));
			}else {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				persons.add(new JuridicPerson(name, anualIncome, numberOfEmployees));
			}	
		}
		
		double totalTaxes = 0;
		System.out.println("TAXES PAID: ");
		for(Person person : persons) {
			System.out.println(person);
			totalTaxes += person.impostsCost();
		}
		
		System.out.println("TOAL TAXES: " + totalTaxes);
		
		
		sc.close();
	}

}
