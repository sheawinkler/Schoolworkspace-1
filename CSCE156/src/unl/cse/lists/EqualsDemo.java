package unl.cse.lists;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class EqualsDemo {

	public static void main(String args[]) {
		
		ArrayList<UserClassA> listA = new ArrayList<UserClassA>();
		ArrayList<UserClassB> listB = new ArrayList<UserClassB>();
		
		UserClassA a = new UserClassA(10, 20.0);
		UserClassA b = new UserClassA(30, 50.0);
		UserClassA c = new UserClassA(10, 20.0);

		listA.add(a);
		listA.add(b);
		
		System.out.println("listA = "+listA);
		System.out.println("listA.contains(c) ? "+listA.contains(c));

		UserClassB d = new UserClassB(10, 20.0);
		UserClassB e = new UserClassB(30, 50.0);
		UserClassB f = new UserClassB(10, 20.0);

		listB.add(d);
		listB.add(e);
		
		System.out.println("listB = "+listB);
		System.out.println("listB.contains(f) ? "+listB.contains(f));
		
		//Demonstration that mutable objects should be handled
		//with care when used in the Collections framework...
		
		/*
		 * A set usually only has *UNIQUE* elements (unique with respect to the
		 * equals and hashcode methods)...
		 */
		Set<UserClassB> theSet = new HashSet<UserClassB>();
		theSet.add(d);
		theSet.add(e);
		//adding d, e is fine
		System.out.println(theSet);
		//adding f has no effect since it is equal to d, but...
		theSet.add(f);
		System.out.println(theSet);
		//adding f mutated does have an effect:
		f.setInteger(15);
		theSet.add(f);
		System.out.println(theSet);
		//but now we can change it back forcing the Set to have
		//duplicate elements:
		f.setInteger(10);
		System.out.println(theSet);

	}
}
