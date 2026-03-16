package math_cli.model;

public class Circle extends Figure {

	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double calculateArea() {
		return radius * radius * Math.PI;
	}

	@Override
	protected String getFigureName() {
		return "круг";
	}

}
