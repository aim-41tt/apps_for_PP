package math_cli.model;

public class Circle implements Figure {
	
	private double r; // радиус

	@Override
	public double areaFigure() {
		return r*Math.PI;
	}

	/**
	 * @param r - радиус круга
	 */
	public Circle(double r) {
		this.r = r;
	}

}
