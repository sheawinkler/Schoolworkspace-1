package unl.cse;

/*
 * The Deposit.java class extends the Asset.java.  The class has two 
 * constructors and getter/setter methods for the variables.
 */


public class Deposit extends Asset {

	private double APR;
	private double amount;
	
	public Deposit(String code, char letter, String label, char letter2,
			double aPR, double amount) {
		super(code, letter, label);
		this.APR = aPR;
		this.amount = amount;
	}
	public Deposit() {
		super();
		this.APR =0.0;
	}
	public double getAPR() {
		return APR;
	}
	public void setAPR(double aPR) {
		this.APR = aPR;
	}
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return this.amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public double getValue() {
		return this.getAmount();
	}
	@Override
	public double annualReturn() {
		double APY=0, annualReturn =0;
		APY = Math.expm1(this.getAPR()/100);
		annualReturn = this.getAmount()*(APY);
		return annualReturn;
	}
	@Override
	public double rateOfReturn() {
		return (this.annualReturn()/this.getAmount())*100;
	}
}
