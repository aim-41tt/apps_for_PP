package math_cli.model;

public abstract class Figure {

	public abstract double calculateArea();

	public String formatArea() {
		double roundedArea = Math.round(calculateArea() * 100) / 100.0;
		return String.format("Площадь %sа = %.2f", getFigureName(), roundedArea);
	}

	protected abstract String getFigureName();

}
