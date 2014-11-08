package unl.cse.oop;

public class OverloadingMethods {

	public void foo() {
		System.out.println("I don't know how to foo");
	}
	
	public void foo(Integer a) {
		System.out.println("I don't know how to foo " + a);
	}
	
	public void foo(Double b) {
		System.out.println("I don't know how to foo " + b);
	}
	
	public void foo(Integer a, Double b) {
		System.out.println("I don't know how to foo " + a + " nor " + b);
	}

	public int foo(String s) {
		System.out.println("I don't know how to foo " + s + " but I can return an int...");
		return 10;
	}

//NOT allowed:
//	public void foo(Integer a) {
//		System.out.println("What's a foo?");
//	}

//NOT allowed:
//	public int foo(Integer a) {
//		System.out.println("I don't know how to foo " + a);
//	}

}
