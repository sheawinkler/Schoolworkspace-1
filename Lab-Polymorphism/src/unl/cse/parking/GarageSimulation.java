package unl.cse.parking;

public class GarageSimulation {
	public static void main(String[] args) {
		
		Garage safePark = new Garage(10);

		CompactCar stan = new CompactCar("ABC 123");
		safePark.addVehicle(stan);
		SUV bob = new SUV("QED NEB");
		safePark.addVehicle(bob);
		
		safePark.addDay();
		
		safePark.addDay();
		
		Motorbike charlie = new Motorbike("XYZ 321");
		safePark.addVehicle(charlie);
		
		
		safePark.addDay();
		
		Motorbike lisa = new Motorbike("QT 42");
		safePark.addVehicle(lisa);
		
		CompactCar rick = new CompactCar("FOO 459");
		safePark.addVehicle(rick);
		
		safePark.addDay();
		safePark.addDay();
		
		safePark.removeVehicle(lisa);
		
		safePark.addDay();
		safePark.addDay();
		safePark.displayReport();
		
		//New week
		safePark.addDay();
		
		safePark.removeVehicle(stan);
		safePark.addDay();
		safePark.addDay();
		CompactCar july = new CompactCar("BAR 560");
		safePark.addVehicle(july);
		safePark.addDay();
		safePark.addDay();
		safePark.addDay();
		safePark.displayReport();
		
		safePark.addDay();
		//another week
		safePark.removeVehicle(bob);
		safePark.addDay();
		safePark.addDay();
		
		
	
		
		SUV jon = new SUV("CSE 444");
		safePark.addVehicle(jon);
		Motorbike stanley = new Motorbike("QT 42");
		safePark.addVehicle(stanley);
		safePark.addDay();
		safePark.addDay();
		safePark.addDay();
		safePark.addDay();
		safePark.addDay();
		safePark.displayReport();
		
	}
}
