package unl.cse.parking;

public class Motorbike extends Vehicle {
	public Motorbike(String license){
		super(license);
	}
	
	public double totalPay(){
		int numberOfDays = this.getnumberOfDays();
		double total=0;
		if(numberOfDays<7){
			total = numberOfDays * 4 ;
		}
		else{
			total = numberOfDays * 3 ;
		}
		return total;
	}
}
