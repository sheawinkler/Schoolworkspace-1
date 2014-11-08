package unl.cse.oop.rectangle_problem;

public class Rectangle extends Shape {

	private Double length;
	private Double width;
	
	public Rectangle(Double length, Double width) {
		this.setLength(length);
		this.setWidth(width);
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getArea() {
		if(length == null || width == null || length.doubleValue() < 0.0 || width.doubleValue() < 0.0)
			return null;
		else
			return length * width;
	}

	
}
