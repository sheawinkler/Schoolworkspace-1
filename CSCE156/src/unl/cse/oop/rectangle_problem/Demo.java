package unl.cse.oop.rectangle_problem;

public class Demo {

	
	public static void main(String args[]) {

		Square s = new Square(10.0);
		
		s.setLength(20.0);
		
		System.out.println("s is of type "+s.getClass());
		System.out.println("s = "+s);

		if(s instanceof unl.cse.oop.rectangle_problem.Square) {
			System.out.println("s is-a Square");
		}
		if(s instanceof unl.cse.oop.rectangle_problem.Rectangle) {
			System.out.println("s is-a Rectangle");
		}
		if(s instanceof unl.cse.oop.rectangle_problem.Shape) {
			System.out.println("s is-a Shape");
		}
		
		System.out.println("Calling the area method: area = "+s.getArea());
	}
}
