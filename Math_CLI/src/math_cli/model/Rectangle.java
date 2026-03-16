package math_cli.model;

public class Rectangle implements Figure {
	
	private double w; // ширина
	private double l; // длина

	@Override
	public double areaFigure() {
		return w*l;
	}

	/**
	 * @param w - ширина
	 * @param l - длина
	 */
	public Rectangle(double w, double l) {
		this.w = w;
		this.l = l;
	}

}
