package unl.cse.oop.inheritance;

public class Ostrich extends Bird {

	@Override
	public void move() {
		walk();
	}
	
	public void walk() {
		System.out.println("\twalking!");
	}

}
