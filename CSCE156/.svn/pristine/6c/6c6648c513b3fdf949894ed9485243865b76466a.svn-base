package unl.cse.oop.inheritance;

public class Dog extends Animal {

	private int numberOfLegs;
	
	//Demo: by default, constructors are not inherited; they need to be specified and 
	//      if the super class's constructor is to be used, it can be accessed via super():
	public Dog(int height, int numLegs) {
		//more over, if called, it must be the FIRST thing done in the constructor:
		super(height);
		//also, since height is private in the super class, though Dog has it, it is not visible:
		//NOT ALLOWED: this.height = height;
		this.numberOfLegs = numLegs;
	}

	public int getNumberOfLegs() {
		return numberOfLegs;
	}
	
	@Override
	protected void eat() {
		System.out.println("Eating a bone...");
	}

}
