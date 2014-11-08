package unl.cse;

/*
 * The PrivateInvestment.java class extends Investment.java.  
 * More specifically, the PrivateInvestment.java class adds variables to compute a PrivateInvestment. 
 * The class has two constructors and getter/setter methods for the variables.
 */

public class PrivateInvestment extends Investment{
	
	private double totalValue;
	private double percentageStake;
	private double omegaMeasure;

	public PrivateInvestment(String code, char letter, String label,
			double quarterlyDivident, double baseRateOfReturn,
			String stockSymbol, double totalValue, double percentageStake,
			double omegaMeasure) {
		super(code, letter, label, quarterlyDivident, baseRateOfReturn,
				stockSymbol);
		this.totalValue = totalValue;
		this.percentageStake = percentageStake;
		this.omegaMeasure = omegaMeasure;
	}
	public PrivateInvestment() {
		super();
		this.totalValue = (0.0);
		this.percentageStake = 0.0;
		this.omegaMeasure = 0.25;
		// TODO Auto-generated constructor stub
	}
	public double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	/**
	 * @return the percentageStake
	 */
	public double getPercentageStake() {
		return percentageStake;
	}
	/**
	 * @param percentageStake the percentageStake to set
	 */
	public void setPercentageStake(double percentageStake) {
		this.percentageStake = percentageStake;
	}
	public double getOmegaMeasure() {
		return omegaMeasure;
	}
	@Override
	public double getValue() {
		double value = this.totalValue *(this.percentageStake/100);
		return value;
	}
	@Override
	public double rateOfReturn() {
		return (this.annualReturn()/this.getValue())*100;
	}
	@Override
	public double annualReturn() {
		double dividend = 0.0, annualReturn = 0.0;
		dividend = (this.getQuarterlyDivident()*(this.getPercentageStake()/100))*4;
		annualReturn = dividend +(this.getBaseRateOfReturn()/100*this.getTotalValue())*(this.getPercentageStake()/100);
		return annualReturn;
	}
	@Override
	public void setOmegaMeasure(double omegaMeasure) {
		this.omegaMeasure = (omegaMeasure);
	}
	public void addOmegaMeasure(double d) {
		this.omegaMeasure += d;
	}
}
