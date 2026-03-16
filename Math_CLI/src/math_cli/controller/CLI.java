package math_cli.controller;

import java.util.Scanner;

import math_cli.model.Circle;
import math_cli.model.Figure;
import math_cli.model.Rectangle;
import math_cli.model.Square;

public class CLI {

	public void start() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\nВыберите фигуру:");
			System.out.println("1 - Круг");
			System.out.println("2 - Квадрат");
			System.out.println("3 - Прямоугольник");
			System.out.println("0 - Выход");
			System.out.print("Ваш выбор: ");

			String choice = scanner.nextLine().trim();

			switch (choice) {
			case "1" -> circle(scanner);
			case "2" -> square(scanner);
			case "3" -> rectangle(scanner);
			case "0" -> {
				System.out.println("До свидания!");
				return;
			}
			default -> System.out.println("Ошибка: введите 0, 1, 2 или 3.");
			}
		}
	}

	private static void rectangle(Scanner scanner) {
		double w = readPositiveDouble(scanner, "Введите длину: ");
		double l = readPositiveDouble(scanner, "Введите ширину: ");

		if (w == l) {
			System.out.println("Это квадрат, а не прямоугольник");
			return;
		}
		
		Figure c = new Rectangle(w, l);
		calculation(c.areaFigure(), "прямоугольник");
	}

	private static void square(Scanner scanner) {
		Figure c = new Square(readPositiveDouble(scanner, "Введите длину стороны: "));
		calculation(c.areaFigure(), "квадрат");
	}

	private static void circle(Scanner scanner) {

		Figure c = new Circle(readPositiveDouble(scanner, "Введите радиус: "));
		calculation(c.areaFigure(), "круг");
	}

	private static void calculation(double answer, String typeFigure) {
	    double rounded = Math.round(answer * 100) / 100.0;
	    System.out.printf("Площадь %sа = %.2f%n", typeFigure, rounded);
	}

	private static double readPositiveDouble(Scanner scanner, String prompt) {
	    while (true) {
	        System.out.print(prompt);
	        String input = scanner.nextLine().trim().replace(",", ".");
	        try {
	            double value = Double.parseDouble(input);
	            if (value <= 0) {
	                System.out.println("Ошибка: значение должно быть больше нуля.");
	                continue;
	            }
	            if (Double.isInfinite(value) || Double.isNaN(value)) {
	                System.out.println("Ошибка: недопустимое значение.");
	                continue;
	            }
	            return value;
	        } catch (NumberFormatException e) {
	            System.out.println("Ошибка: введите числовое значение.");
	        }
	    }
	}

}
