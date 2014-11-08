package unl.cse.parking;

public class CompactCar extends Vehicle {
	public CompactCar(String license){
		super(license);
	}
	
	public double totalPay(){
		int numberOfDays = this.getnumberOfDays();
		double total=0;
		if(numberOfDays<7){
			total = numberOfDays * 6 ;
		}
		else{
			total = numberOfDays * 4.5 ;
		}
		return total;
	}
}
