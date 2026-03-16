package math_cli.controller;

import java.util.Scanner;

public class ConsoleReader {
	
	private final Scanner scanner;

	public ConsoleReader() {
		this.scanner = new Scanner(System.in);
	}

	public String readLine() {
		return scanner.nextLine().trim();
	}

	public double readPositiveDouble(String prompt) {
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
