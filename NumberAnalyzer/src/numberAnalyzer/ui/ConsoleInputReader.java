package numberAnalyzer.ui;

import java.util.List;
import java.util.Scanner;

import numberAnalyzer.parser.NumberParser;

public class ConsoleInputReader<T extends Number> {

	private final Scanner scanner;
	private final NumberParser<T> parser;

	public ConsoleInputReader(Scanner scanner, NumberParser<T> parser) {
		this.scanner = scanner;
		this.parser = parser;
	}

	public List<T> readNumberList(String prompt) {
		while (true) {
			System.out.print(prompt);
			String input = scanner.nextLine().trim();

			if (input.isBlank()) {
				System.out.println("Ошибка: строка не должна быть пустой. Попробуйте ещё раз.");
				continue;
			}

			try {
				List<T> numbers = parser.parse(input);
				if (numbers.isEmpty()) {
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
