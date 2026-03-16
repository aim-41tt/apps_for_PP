package math_cli.model;

public class Square implements Figure {
	
	private double a;

	@Override
	public double areaFigure() {
		return a*a;
	}

	/**
	 * @param a - длина стороны квадрата
	 */
	public Square(double a) {
		this.a = a;
	}

}
