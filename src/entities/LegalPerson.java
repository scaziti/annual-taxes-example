package entities;

public class LegalPerson extends Person{

	private Integer numberOfEmployees;
	
	public LegalPerson() {
	}
	
	public LegalPerson(String name, Double income, Integer numberOfEmployees) {
		super(name, income);
		this.numberOfEmployees = numberOfEmployees;
	}

	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public double taxes() {
		if (numberOfEmployees > 10) {
			return getAnnualIncome() * 0.14;
		} else {
			return getAnnualIncome() * 0.16;
		}
	}

}
