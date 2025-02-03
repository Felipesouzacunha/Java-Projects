package model.services;

public interface OnlinePaymentSerive {

	public Double paymentFee(double amount);

	public Double interest(Double amount, Integer months);

}
