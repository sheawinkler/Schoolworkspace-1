package unl.cse.trucks;

public class Driver {

    public static void main (String[] args){

    	//TODO: Test cases should be made here
    	TruckList tl = new TruckList();
    	Truck t = new Truck.Builder().licensePlate("ABC 123").build();
    	Truck truck1 = new Truck.Builder().licensePlate("one").build();
    	Truck truck2 = new Truck.Builder().licensePlate("two").build();
    	Truck truck3 = new Truck.Builder().licensePlate("three").build();
    	Truck truck4 = new Truck.Builder().licensePlate("four").build();
    	Truck truck5 = new Truck.Builder().licensePlate("five").build();
    	Truck truck6 = new Truck.Builder().licensePlate("six").build();
    	Truck truck7 = new Truck.Builder().licensePlate("seven").build();
    	Truck truck10 = new Truck.Builder().licensePlate("Add_to-Begining").build();
    	Truck truck9 = new Truck.Builder().licensePlate("nine").build();
    	//Truck truck8 = new Truck.Builder().licensePlate("eight").build();
    	//Truck truck11 = new Truck.Builder().licensePlate("remove").build();
    	tl.addToStart(t);
    	tl.addToEnd(truck1);
    	tl.addToEnd(truck2);
    	tl.addToEnd(truck3);
    	tl.addToEnd(truck4);
    	tl.addToEnd(truck5);
    	tl.addToEnd(truck6);
    	tl.addToEnd(truck7);
    	tl.addToEnd(truck9);
    	tl.print();
    	tl.remove(0);
    	//tl.addToStart(truck1);
    	tl.print();
    	tl.addToStart(truck10);
    	tl.remove(8);
    	tl.print();
    	System.out.println("getlast truck\t"+tl.getTruck(7));
    	//System.out.println("getlast truck\t"+tl.getTruck(8));
    	
    	TruckList tl1 = new TruckList();
    	Truck t1 = new Truck.Builder().licensePlate("first").build();
    	Truck t2 = new Truck.Builder().licensePlate("1").build();
    	Truck t3 = new Truck.Builder().licensePlate("2").build();
    	Truck t4 = new Truck.Builder().licensePlate("3").build();
    	Truck t5 = new Truck.Builder().licensePlate("4").build();
    	Truck t6 = new Truck.Builder().licensePlate("5").build();
    	Truck t7 = new Truck.Builder().licensePlate("6").build();
    	Truck t8 = new Truck.Builder().licensePlate("7").build();
    	Truck t9 = new Truck.Builder().licensePlate("8").build();
    	Truck t10 = new Truck.Builder().licensePlate("9").build();
    	tl1.addToStart(t1);
    	tl1.addToStart(t2);
    	tl1.addToStart(t3);
    	tl1.print();
    	tl1.addToEnd(t4);
    	tl1.addToEnd(t5);
    	tl1.addToEnd(t6);
    	tl1.print();
    	tl1.addToEnd(t7);
    	tl1.addToStart(t8);
    	tl1.addToEnd(t9);
    	tl1.addToStart(t10);
    	tl1.addToEnd(t1);
    	tl1.addToStart(t2);
    	tl1.print();
    	
    	tl1.addToStart(t1);
    	tl1.addToStart(t2);
    	tl1.addToStart(t3);
    	tl1.print();
    	tl1.remove(0);
    	tl1.print();
    	
    	tl1.addToStart(t1);
    	tl1.addToStart(t2);
    	tl1.addToStart(t3);
    	tl1.print();
    	tl1.remove(16);
    	tl1.print();
    	tl1.clear();
    	tl1.print();
    	
    	tl1.addToEnd(t2);
    	tl1.addToEnd(t3);
    	tl1.addToEnd(t4);
    	tl1.addToEnd(t5);
    	tl1.addToEnd(t6);
    	tl1.print();
    	tl1.remove(2);
    	tl1.print();
    	tl1.remove(3);
    	tl1.print();
    	tl1.remove(0);
    	tl1.print();
    	tl1.remove(2);
    	tl1.print();
    	tl1.remove(0);
    	tl1.print();
    	
    	
	}
}
