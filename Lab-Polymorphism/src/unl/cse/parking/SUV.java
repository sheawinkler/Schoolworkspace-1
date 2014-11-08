package unl.cse.parking;

public class SUV extends Vehicle {
	public SUV(String license){
		super(license);
	}
	public double totalPay(){
		int numberOfDays = this.getnumberOfDays();
		double total=0;
		if(numberOfDays<7){
			total = numberOfDays * 8 ;
		}
		else{
			total = numberOfDays * 6 ;
		}
		return total;
	}
}
