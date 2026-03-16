package math_cli.model;

public class Rectangle extends Figure {

	private double width; // ширина
	private double length; // длина

	public Rectangle(double width, double length) {
		this.width = width;
		this.length = length;
	}

	@Override
	public double calculateArea() {
		return width * length;
	}

	@Override
	protected String getFigureName() {
		return "прямоугольник";
	}

}
