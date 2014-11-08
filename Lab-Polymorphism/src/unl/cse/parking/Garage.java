package unl.cse.parking;

public class Garage {

	private final Vehicle stalls[];
	
	public Garage(int capacity) {
		stalls = new Vehicle[capacity];
	}
	
	/**
	 * "Parks" the vehicle in a stall if one is available.  Returns true if
	 * the vehicle was added successfully; false otherwise.
	 */
	public boolean addVehicle(Vehicle automobile) {
		//TODO: implement this method
		boolean parked = false;
			for(int i =0; i<stalls.length; i++){
				if(stalls[i] == null && parked == false ){
					stalls[i] = automobile;
					parked = true;
				}
			}
			if(parked){
				return true;
			}else{
				return false;
			}
	}
	
	/**
	 * Remove the vehicle having the provided
	 * license plate number from the garage. The method returns
	 * the vehicle if it is found otherwise it returns null. 
	 */
	public Vehicle removeVehicle(Vehicle automobile) {
		boolean removed = false;
		Vehicle foundCar = null; 
		for(int i =0; i<stalls.length; i++){
		
			if(stalls[i] != null) {
				if (stalls[i].getLicense() == automobile.getLicense() && !removed){
				
					foundCar = stalls[i];
					stalls[i] = null;
				
					removed = true;
				}
			}
		}	
		return foundCar;
	}
		
	/**
	 * Returns the maximum capacity of this Garage
	 */
	public int getCapacity() {
		return this.stalls.length;
	}
	
	/**
	 * Returns the number of empty stalls in the garage--the number of open
	 * spots
	 * @return
	 */
	public int getNumFreeSpots() {
		int freeSpots = 0;
		for(int i=0; i<stalls.length; i++) {
			if(stalls[i] == null) {
				freeSpots++;
			}
		}
		return freeSpots;
	}

	/**
	 * Simulates the passing of a day by adding a day in the garage to each vehicle
	 * in the garage.
	 * @return
	 */
	public void addDay() {
		//TODO: implement this
		for(int i=0; i<this.stalls.length; i++){
			if(stalls[i] != null) {
				stalls[i].addDay();
			}
		}
	}
	
	public double weekTotal(){
		double newTotal = 0;
		for(int i=0; i<this.stalls.length; i++){
			newTotal = newTotal+stalls[i].totalPay();
		}
		return newTotal;
	}
	
	public void addDay(int numDays) {
		//TODO: optionally implement this as well
		for(int i=0; i<this.stalls.length; i++){
			if(stalls[i] != null) {
				//stalls[i].addDay(stalls[i].addDay()+numDays);
			}
		}
	}
	
	/**
	 * Displays the current "state" of the garage by printing out information about each
	 * stall
	 */
	public void displayReport() {
		
		System.out.println("Stall License Type Days Total Fee");
		for(int i=0; i<this.stalls.length; i++) {
			if(stalls[i] == null) {
				System.out.println(String.format("%3d EMPTY", (i+1)));
			} else {
				//TODO: You will need to modify these arguments to display the report correctly
				System.out.println(String.format("%3d %-10s %-11s %3d $%5.2f", (i+1), 
						(stalls[i]==null)?"EMPTY":stalls[i].getLicense(), stalls[i].getClass().getSimpleName(), 
						stalls[i].getnumberOfDays(), stalls[i].totalPay() ));
			}
		}
	}
}