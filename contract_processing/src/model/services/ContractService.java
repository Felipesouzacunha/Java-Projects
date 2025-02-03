package model.services;

import java.time.LocalDate;

import model.entities.Contract;

public class ContractService {

	private OnlinePaymentSerive onlinePaymentService;

	public ContractService(OnlinePaymentSerive onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract contract, Integer months) {
		LocalDate date = contract.getDate();
		for (int i = 0; i < months; i++) {
			double amount = contract.getToalValue() / months;
			amount += onlinePaymentService.interest(200.00, i + 1);
			amount += onlinePaymentService.paymentFee(amount);
			LocalDate futureDate = date.plusMonths(i + 1);
			contract.addinstallments(futureDate, amount);
		}
	}
}
