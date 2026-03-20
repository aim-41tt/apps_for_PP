package stringAnalyzer.UI;

import java.util.Scanner;

import stringAnalyzer.model.StringAnalysisResult;
import stringAnalyzer.service.StringAnalysisService;

public class ConsoleStringAnalyzerUI {

	private static final String EXIT_RU = "выход";
	private static final String EXIT_EN = "exit";

	private final StringAnalysisService analysisService;
	private final StringAnalysisResultPrinter printer;
	private final Scanner scanner;

	public ConsoleStringAnalyzerUI(StringAnalysisService analysisService, StringAnalysisResultPrinter printer,
			Scanner scanner) {
		this.analysisService = analysisService;
		this.printer = printer;
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
			printer.print(result);

			System.out.println("\nВведите следующую строку (или 'выход' для завершения):");
		}
	}

}
