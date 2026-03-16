package math_cli.model;

public class Square extends Figure {

	private double side;

	public Square(double side) {
		this.side = side;
	}

	@Override
	public double calculateArea() {
		return side * side;
	}

	@Override
	protected String getFigureName() {
		return "квадрат";
	}

}
