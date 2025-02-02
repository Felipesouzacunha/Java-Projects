package model.entities;

import model.exceptions.DomainException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
		
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) throws DomainException {
		
		if(number < 0 || balance < 0 || withdrawLimit < 0) {
			throw new DomainException("Is expceted numbers greater than 0 to open a account");
		}
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getWithdrawLmit() {
		return withdrawLimit;
	}

	public void setWithdrawLmit(Double withdrawLmit) {
		this.withdrawLimit = withdrawLmit;
	}

	public Double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) throws DomainException {
		
		if(amount < 0 ) {
			throw new DomainException("Deposti anount must be greater than 0 ");
		}
		this.balance += amount;
	}
	
	public void withdraw(double amount) throws DomainException {
		if (this.balance < amount) {
			throw new DomainException("Not wnough balance");
		}
		if (this.withdrawLimit < amount) {
			throw new DomainException("The amount exceed withdraw limit");
			
		}
		this.balance -= amount;
	}
	
	@Override
	public String toString() {
		return "New balance: " + this.balance;
	}
	
}
