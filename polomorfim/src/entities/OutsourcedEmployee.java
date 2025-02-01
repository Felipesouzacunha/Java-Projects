package entities;

public final class OutsourcedEmployee extends Employee {
	
	private Double addtionalCharge;
	
	public OutsourcedEmployee() {
		super();
	}

	public OutsourcedEmployee(String name, Integer hours, Double valuePerHour, Double addtionalCherge) {
		super(name, hours, valuePerHour);
		this.addtionalCharge = addtionalCherge;
	}

	public Double getAddtionalCherge() {
		return addtionalCharge;
	}

	public void setAddtionalCherge(Double addtionalCherge) {
		this.addtionalCharge = addtionalCherge;
	}
	
	@Override
	public final Double payment() {
		return super.payment() + addtionalCharge * 1.1;
	}
	
}
