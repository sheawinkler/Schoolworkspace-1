package unl.cse;

/*
 * Stock.java class defines the stock details of an individual stock.  The stock class 
 * extends the Investment.java.  Stock.java has two constructors and getter/setter methods for its variables.
 */

public class Stock extends Investment{
	
	private double sharePrice;
	private double shareOwned;
	private double omegaMeasure;
	
	public Stock(String code, char letter, String label,
			double quarterlyDivident, double baseRateOfReturn,
			String stockSymbol, double sharePrice, double shareOwned,
			double omegaMeasure) {
		super(code, letter, label, quarterlyDivident, baseRateOfReturn,
				stockSymbol);
		this.sharePrice = sharePrice;
		this.shareOwned = shareOwned;
		this.omegaMeasure = omegaMeasure;
	}
	public Stock() {
		super();
		this.shareOwned = 0.0;
		this.sharePrice = 0.0;
		this.omegaMeasure = 0.1;
	}
	public double getSharePrice() {
		return sharePrice;
	}
	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}
	/**
	 * @return the shareOwned
	 */
	public double getShareOwned() {
		return shareOwned;
	}
	/**
	 * @param shareOwned the shareOwned to set
	 */
	public void setShareOwned(double shareOwned) {
		this.shareOwned = shareOwned;
	}
	public double getOmegaMeasure() {
		return omegaMeasure;
	}
	@Override
	public String toString() {
		return "Stock [Share Price=" + sharePrice + "]";
	}
	public double getValue(){
		return (this.sharePrice*this.shareOwned);
	}
	@Override
	public double rateOfReturn() {
		return this.annualReturn()/this.getValue()*100;
	}
	@Override
	public double annualReturn() {
		double annualReturn = 0.0;
		annualReturn = this.getBaseRateOfReturn()/100*this.getValue();
		annualReturn +=(this.getQuarterlyDivident()*this.getShareOwned())*4;
		return annualReturn;
	}
	public void setOmegaMeasure(double omega) {
		this.omegaMeasure = (omega );
	}
	public void addOmegaMeasure(double omega) {
		this.omegaMeasure += (omega );
	}
}
