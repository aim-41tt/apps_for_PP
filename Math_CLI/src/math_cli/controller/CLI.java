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
			case "1" -> handleCircle();
			case "2" -> handleSquare();
			case "3" -> handleRectangle();
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

	private void handleCircle() {
		double radius = consoleReader.readPositiveDouble("Введите радиус: ");
		Figure circle = new Circle(radius);
		printArea(circle);
	}

	private void handleSquare() {
		double side = consoleReader.readPositiveDouble("Введите длину стороны: ");
		Figure square = new Square(side);
		printArea(square);
	}

	private void handleRectangle() {
		double width = consoleReader.readPositiveDouble("Введите ширину: ");
		double length = consoleReader.readPositiveDouble("Введите длину: ");

		if (width == length) {
			System.out.println("Это квадрат, а не прямоугольник.");
			return;
		}

		Figure rectangle = new Rectangle(width, length);
		printArea(rectangle);
	}

	private void printArea(Figure figure) {
		System.out.println(figure.formatArea());
	}

}
