package unl.cse;

/*
 * The Investment.java class extends the Asset.java class.  Investment.java has two constructors 
 * and getter/setter methods for its variables.
 */

public abstract class Investment extends Asset{
	
	private double quarterlyDivident;
	private double baseRateOfReturn;
	private String stockSymbol;
	
	public Investment(String code, char letter, String label,
			double quarterlyDivident, double baseRateOfReturn,
			String stockSymbol) {
		super(code, letter, label);
		this.quarterlyDivident = quarterlyDivident;
		this.baseRateOfReturn = baseRateOfReturn;
		this.stockSymbol = stockSymbol;
	}
	public Investment() {
		super();
		this.quarterlyDivident = 0.0;
		this.baseRateOfReturn = 0.0;
		this.stockSymbol = new String();
	}
	public Investment(String code, char letter, String label) {
		super(code, letter, label);
	}
	public double getQuarterlyDivident() {
		return quarterlyDivident;
	}
	public void setQuarterlyDivident(double quarterlyDivident) {
		this.quarterlyDivident = quarterlyDivident;
	}
	public double getBaseRateOfReturn() {
		return baseRateOfReturn;
	}
	public void setBaseRateOfReturn(double baseRateOfReturn) {
		this.baseRateOfReturn = baseRateOfReturn;
	}
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	public abstract void setOmegaMeasure(double omegaMeasure);
	@Override
	public abstract double getValue();
	public abstract double rateOfReturn();
	public abstract double annualReturn();
}
