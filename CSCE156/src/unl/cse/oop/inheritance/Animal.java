package unl.cse.oop.inheritance;

public class Animal {

	private int height;
	
	public Animal() {
		this.height = -1;
	}
	
	public Animal(int height) {
		this.height = height;
	}
	
	protected void eat() {
		System.out.println("eating...");
	}
	
	public int getHeight() {
		return this.height;
	}
	
}
