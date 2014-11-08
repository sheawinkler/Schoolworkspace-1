package unl.cse.constructors;

import org.joda.time.DateTime;

public class Person {

	private int age;
	private String name;
	private DateTime birthDate;

	public Person() {
		//defaults are not used, we define our own "defaults":
		this.age = -1;
		this.name = "John Doe";
		this.birthDate = new DateTime(1970, 1, 1, 0, 0, 0, 0);
	}
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;		
	}
	
	public Person(int age, String name, DateTime dt) {
		this.age = age;
		this.name = name;
		this.birthDate = dt;
	}
	
	public String toString() {
		return name + " (" + age + ", " + birthDate + ") ";
	}
	
}
