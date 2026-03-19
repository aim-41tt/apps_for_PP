package stringAnalyzer.UI;

import java.util.Scanner;

import stringAnalyzer.model.StringAnalysisResult;
import stringAnalyzer.service.StringAnalysisService;

public class ConsoleStringAnalyzerUI {
	
	private static final String EXIT_RU = "выход";
	private static final String EXIT_EN = "exit";

	private final StringAnalysisService analysisService;
	private final StringAnalysisResultPrinter printer;
	private final Scanner sc;

	public ConsoleStringAnalyzerUI(StringAnalysisService analysisService, StringAnalysisResultPrinter printer,
			Scanner sc) {
		this.analysisService = analysisService;
		this.printer = printer;
		this.sc = sc;
	}

	public void run() {
		System.out.println("Анализатор строки:");
		System.out.println("Введите строку для анализа (или 'выход' для завершения):");

		while (true) {
			System.out.print("> ");
			String input = sc.nextLine();

			if (input.equalsIgnoreCase(EXIT_RU) || input.equalsIgnoreCase(EXIT_EN)) {
				System.out.println("Завершение программы.");
				break;
			}

			if (input.isBlank()) {
				System.out.println("Строка пустая. Пожалуйста, введите текст.");
				continue;
			}

			StringAnalysisResult result = analysisService.analyze(input);
			printer.print(result);

			System.out.println("\nВведите следующую строку (или 'выход' для завершения):");
		}
	}

}
