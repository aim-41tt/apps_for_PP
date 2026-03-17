package math_cli.controller;

import math_cli.model.Circle;
import math_cli.model.Figure;
import math_cli.model.Rectangle;
import math_cli.model.Square;

public class CLI {

	private final ConsoleReader consoleReader;

	public CLI() {
		 this.consoleReader = new ConsoleReader();
	}

	public void start() {
		while (true) {
			printMenu();
			String choice = consoleReader.readLine();

			switch (choice) {
			case "1" -> calculateAndPrintCircleArea();
			case "2" -> calculateAndPrintSquareArea();
			case "3" -> calculateAndPrintRectangleArea();
			case "0" -> {
				System.out.println("До свидания!");
				return;
			}
			default -> System.out.println("Ошибка: введите 0, 1, 2 или 3.");
			}
		}
	}

	private void printMenu() {
		System.out.println("\nВыберите фигуру:");
		System.out.println("1 - Круг");
		System.out.println("2 - Квадрат");
		System.out.println("3 - Прямоугольник");
		System.out.println("0 - Выход");
		System.out.print("Ваш выбор: ");
	}

	private void calculateAndPrintCircleArea() {
		System.out.print("Введите радиус: ");
		double radius = consoleReader.readPositiveDouble();
		Figure circle = new Circle(radius);
		System.out.println(circle.formatArea());
	}

	private void calculateAndPrintSquareArea() {
		System.out.print("Введите длину стороны: ");
		double side = consoleReader.readPositiveDouble();
		Figure square = new Square(side);
		System.out.println(square.formatArea());
	}
	
	private void calculateAndPrintRectangleArea() {
		System.out.print("Введите ширину: ");
		double width = consoleReader.readPositiveDouble();
		System.out.print("Введите длину: ");
		double length = consoleReader.readPositiveDouble();

		if (width == length) {
			System.out.println("Это квадрат, а не прямоугольник.");
			return;
		}

		Figure rectangle = new Rectangle(width, length);
		System.out.println(rectangle.formatArea());
	}


}
