package model.services;

public class PaypalService implements OnlinePaymentSerive {

	@Override
	public Double paymentFee(double amount) {
		return amount * 0.02;
	}

	@Override
	public Double interest(Double amount, Integer months) {
		double value = 0;

		for (int i = 0; i < months; i++) {
			value = (amount * 0.01) * months;
		}
		return value;
	}
}