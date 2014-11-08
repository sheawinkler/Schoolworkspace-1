package unl.cse.oop.inheritance;

public class AnimalDemo {

	public static void main(String args[]) {
		
		Animal a = new Animal(5);
		a.eat();
		
		Dog d = new Dog(2, 4);
		System.out.println("I'm a dog of height " + d.getHeight() + " with " + d.getNumberOfLegs() + " legs");
		d.eat();
		
		//though animal has a default constructor, dog does not:
		//NOT ALLOWED: Dog d2 = new Dog();
		
		//subtype polymorphism in action:
		Animal fido = d;
		System.out.println("Feed fido...");
		fido.eat();
	}
}
