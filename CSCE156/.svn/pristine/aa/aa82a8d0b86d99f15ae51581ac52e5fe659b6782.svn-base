package unl.cse.oop.inheritance;

import java.util.Arrays;
import java.util.List;

public class Demo {
	
	/*
	 * This method can accept a list of birds (which may be of type
	 * Bird, Robin, or Ostrich; since they are referenced as Birds,
	 * we have access to the public interface of Bird (namely move())
	 */
	public static void migrate(List<Bird> birds) {
		for(Bird b : birds) {
			b.move();
		}
	}

	public static void main(String args[]) {
		
		Bird b1 = new Bird();
		Robin r = new Robin();
		Ostrich o = new Ostrich();
		
		System.out.println("Calling b1.move()...");
		b1.move();
		//observe: Bird has no fly() method, the following is not possible
		//b1.fly();

		System.out.println("Calling r.move()...");
		r.move();
		System.out.println("Calling r.fly()...");
		r.fly();

		System.out.println("Calling o.move()...");
		o.move();
		System.out.println("Calling o.walk()...");
		o.walk();

		//r is a Robin which is-a Bird so we can refer to it as its super-type:
		//this is known as up-casting
		Bird b2 = r;
		System.out.println("Calling r.move()...");
		b2.move();
		//though its an instance of robin, when referred to as a super-type, only
		//the super-type's interface is available to us, so this is not possible:
		//b2.fly();
		
		//an example of downcasting: in this case, its okay since it was originally
		//a robin
		r = (Robin) b2;
		System.out.println("Calling r.move()...");
		r.move();
		System.out.println("Calling r.fly()...");
		r.fly();
		//note: we can even do a temporary cast to call something:
		System.out.println("Calling ((Robin) b2).fly()...");
		((Robin) b2).fly();
		
		//but attempting to downcast a Bird will not work:
		//syntactically correct, but ClassCastException will occur:
		try {
			r = (Robin) b1;
		} catch (ClassCastException cce) {
			System.err.println(cce.getClass() + " " + cce.getMessage());
		}
		
		System.out.println("Moving the entire flock...");
		migrate(Arrays.asList(r, o, b1));
		
	}
}
