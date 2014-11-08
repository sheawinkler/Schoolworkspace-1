package unl.cse.parking;

public abstract class Vehicle {

	private String license;
	private int numberOfDays = 0;
	
	// The class constructor
	public Vehicle(String license) {
		this.license = license;
	}
	
	/**
	 * The getter method granting public access to reading the
	 * license plate number. Notice license does not have a
	 * setter since it cannot be modified.
	 */
	public String getLicense() {
		return license;
	}
	
	public void setLicense(String License) {
		this.license = License;
	}
	
	public int getnumberOfDays() {
		return this.numberOfDays;
	}
	
	public void addDay() {
		this.numberOfDays++;
	}
	
	public abstract double totalPay();
	
}
