package entities;

public class JuridicPerson extends Person {
	private Integer numberOfEmployees;
	
	public JuridicPerson() {
		
	}

	public JuridicPerson(String name, Double anualIncome, Integer numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public Double impostsCost() {
		double payedImpost;
		if(numberOfEmployees > 10) {
			payedImpost = getAnualIncome() * 0.14;
		}else {
			payedImpost = getAnualIncome() * 0.16;
		}
		return payedImpost;
	}
	
	@Override
	public String toString() {
		return getName() +": $" + String.format("%.2f", impostsCost());
	}
	
}
