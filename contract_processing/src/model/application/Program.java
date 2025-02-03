package model.application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		try {

			System.out.println("enter the contract data:");
			System.out.print("Number: ");
			int contractNumber = sc.nextInt();
			sc.nextLine();
			System.out.print("Date (dd/MM/yyyy): ");
			LocalDate date = LocalDate.parse(sc.nextLine(), fmt);
			System.out.print("Contract value: ");
			double contractValue = sc.nextDouble();
			System.out.print("Enter the number of installments: ");
			int numberOfStallments = sc.nextInt();

			Contract contract = new Contract(contractNumber, date, contractValue);
			
			ContractService service = new ContractService(new PaypalService());
			service.processContract(contract, numberOfStallments);

			System.out.println("Installmentes: ");
			for (Installment installment : contract.getInstallments()) {
				System.out.println(installment);
			}

		} catch (RuntimeException e) {
			System.out.println("Unexpected error: " + e.getMessage());

		} finally {
			sc.close();
		}
	}

}
