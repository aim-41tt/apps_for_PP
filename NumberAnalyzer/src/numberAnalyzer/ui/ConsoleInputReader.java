package numberAnalyzer.ui;


import java.util.Scanner;

import numberAnalyzer.parser.IntegerParser;

public class ConsoleInputReader {

	private final Scanner scanner;
	private final IntegerParser parser;

	public ConsoleInputReader(Scanner scanner, IntegerParser parser) {
		this.scanner = scanner;
		this.parser = parser;
	}

	public int[] readNumberList(String prompt) {
		while (true) {
			System.out.print(prompt);
			String input = scanner.nextLine().trim();

			if (input.isBlank()) {
				System.out.println("Ошибка: строка не должна быть пустой. Попробуйте ещё раз.");
				continue;
			}

			try {
				int[] numbers = parser.parse(input);
				if (numbers.length == 0) {
					System.out.println("Ошибка: список не должен быть пустым. Попробуйте ещё раз.");
					continue;
				}
				return numbers;
			} catch (NumberFormatException e) {
				System.out.println("Ошибка: допустимы только целые числа через пробел. Попробуйте ещё раз.");
			}
		}
	}

}
