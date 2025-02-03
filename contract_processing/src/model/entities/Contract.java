package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
	private Integer number;
	private LocalDate date;
	private Double totalValue;

	private List<Installment> installments = new ArrayList<Installment>();
		
	public Contract(Integer number, LocalDate date, Double totalValue) {
		
		if(number < 0 || totalValue < 0 ) {
			throw new IllegalArgumentException("Values under 0 its not accepted");
		}
		
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getToalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public List<Installment> getInstallments() {
		return installments;
	}

	public void addinstallments(LocalDate date, Double amount) {
		installments.add(new Installment(date, amount));
	}

}
