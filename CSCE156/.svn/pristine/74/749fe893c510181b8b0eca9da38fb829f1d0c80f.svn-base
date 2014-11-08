package unl.cse.constructors;

import org.joda.time.DateTime;

public class PersonDemo {

	public static void main(String args[]) {

		/* primitive or built in types
		 * you assign a VALUE
		 * java knows how to do it
		 */
		Integer n = 10;
		double pi = 3.14;
		boolean b = true;
		char arr[] = {'a', 'b', 'c'};
		String s = "No constructor necessary";
		
		/*
		 * User defined type
		 * java doesn't know what it is
		 * you must specify how to *create* it
		 */
		Person p1;
		p1 = new Person();
		Person p2 = new Person(30, "Joe");
		Person p3 = new Person(20, "Jane", new DateTime(1991, 5, 5, 13, 30, 0));
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
	}
	
}
