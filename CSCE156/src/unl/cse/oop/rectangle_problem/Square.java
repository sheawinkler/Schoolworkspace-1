package unl.cse.oop.rectangle_problem;

public class Square extends Rectangle {

	public Square(Double width) {
		super(width, width);
	}

	@Override
	public String toString() {
		return String.format("%.2f x %.2f", getWidth(), getLength());
	}
	
	@Override 
	public void setLength(Double val) {
		throw new RuntimeException("Calling setLenth on Square is not allowed");
	}
}
