package stringAnalyzer.UI;

import java.util.Scanner;

import stringAnalyzer.model.StringAnalysisResult;
import stringAnalyzer.service.StringAnalysisService;

public class ConsoleStringAnalyzerUI {

	private static final String EXIT_RU = "выход";
	private static final String EXIT_EN = "exit";

	private final StringAnalysisService analysisService;
	private final Scanner scanner;

	public ConsoleStringAnalyzerUI(StringAnalysisService analysisService, Scanner scanner) {
		this.analysisService = analysisService;
		this.scanner = scanner;
	}

	public void run() {
		System.out.println("Анализатор строки:");
		System.out.println("Введите строку для анализа (или 'выход' для завершения):");

		while (true) {
			System.out.print("> ");
			String input = scanner.nextLine();

			if (EXIT_RU.equalsIgnoreCase(input) || EXIT_EN.equalsIgnoreCase(input)) {
				System.out.println("Завершение программы.");
				break;
			}

			StringAnalysisResult result = analysisService.analyze(input);
			printResult(result);

			System.out.println("\nВведите следующую строку (или 'выход' для завершения):");
		}
	}

	private void printResult(StringAnalysisResult result) {
		System.out.println("\nРезультаты анализа:");
		System.out.printf(" Кол-во слов:              %d%n", result.wordCount());
		System.out.printf(" Кол-во букв:              %d%n", result.letterCount());
		System.out.printf(" Кол-во гласных:           %d%n", result.vowelCount());
		System.out.printf(" Кол-во согласных:         %d%n", result.consonantCount());
		System.out.printf(" Кол-во знаков препинания: %d%n", result.punctuationCount());
		System.out.printf(" Кол-во пробелов:          %d%n", result.spaceCount());
	}
}
