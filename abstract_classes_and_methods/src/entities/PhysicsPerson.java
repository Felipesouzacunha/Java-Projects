package entities;

public class PhysicsPerson extends Person {
	private Double healthCosts;
	
	public PhysicsPerson() {
		super();
	}

	public PhysicsPerson(String name, Double anualIncome, Double healthCosts) {
		super(name, anualIncome);
		this.healthCosts = healthCosts;
	}

	public Double getHealthCosts() {
		return healthCosts;
	}

	public void setHealthCosts(Double healthCosts) {
		this.healthCosts = healthCosts;
	}
	
	@Override
	public Double impostsCost() {
		Double payedImpost;
		if(getAnualIncome() < 20000) {
			payedImpost = (getAnualIncome() * 0.15) - (healthCosts * 0.5);
		}else {
			payedImpost = (getAnualIncome() * 0.25) - (healthCosts * 0.5);
		}
		return payedImpost;
	}
	
	@Override
	public String toString() {
		return getName() +": $" + String.format("%.2f", impostsCost());
	}
	
}
