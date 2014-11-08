package unl.cse.weiss;

@SuppressWarnings("finally")
public class Exercise_2_9 {

	public static int foo() {
		try {
			return 0;
		} finally { 
			return 1;
		}
	}
	
	public static void bar() {
		try {
			throw new NullPointerException();
		} catch(Exception e) {
			System.out.println("in the catch block...");
			throw new IllegalStateException();
		} finally {
			throw new ArithmeticException();
		}
	}
	
	public static void main(String args[]) {
		
		int result = foo();
		System.out.println("result = "+result);
		
		try {
			bar();
		} catch(Exception e) {
			System.out.println("Exception is "+e.getClass());
		}
		
	}
}
