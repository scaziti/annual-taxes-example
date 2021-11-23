package entities;

public class NaturalPerson extends Person{

	private Double healthExpenditure;
	
	public NaturalPerson() {
		
	}
	
	public NaturalPerson(String name, Double income, Double healthExpenditure) {
		super(name, income);
		this.healthExpenditure = healthExpenditure;
	}
	
	public Double getHealthExpenditure() {
		return healthExpenditure;
	}

	public void setHealthExpenditure(Double healthExpenditure) {
		this.healthExpenditure = healthExpenditure;
	}

	@Override
	public double taxes() {
		if (getAnnualIncome() <= 20_000.00) {
			return (getAnnualIncome() * 0.15) - (healthExpenditure * 0.5);
		} else {
			return (getAnnualIncome() * 0.25) - (healthExpenditure * 0.5);
		}
	}

}
