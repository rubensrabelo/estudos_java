package model.entities;

public class BussinessAccount extends Account {
	
	private Double loanLimit;

	public BussinessAccount() {
		super();
	}
	
	
	
	public BussinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
		super(number, holder, balance);
		this.loanLimit = loanLimit;
	}
	
	public Double getLoanLimit() {
		return loanLimit;
	}

	public void setLoanLimit(Double loanLimit) {
		this.loanLimit = loanLimit;
	}
	
	public void loan(Double amount) {
		if (amount <= loanLimit) this.balance += amount - 10.0;
	}
	
	@Override
	public void withdraw(Double amount) {
		this.balance -= amount;
	}
}
