package numberAnalyzer.ui;

import java.util.Arrays;
import java.util.stream.Collectors;

import numberAnalyzer.model.NumberListAnalysisResult;
import numberAnalyzer.service.NumberListAnalysisService;

public class ConsoleNumberAnalyzerUI {

	private final NumberListAnalysisService analysisService;
	private final ConsoleInputReader inputReader;

	public ConsoleNumberAnalyzerUI(NumberListAnalysisService analysisService, ConsoleInputReader inputReader) {
		this.analysisService = analysisService;
		this.inputReader = inputReader;
	}

	public void run() {
		System.out.println("Анализатор списков чисел\n");

		int[] firstList = inputReader.readNumberList("Введите числа для первого списка через пробел:  ");
		System.out.println();
		NumberListAnalysisResult firstResult = analysisService.analyze(firstList);
		printAnalysis(firstResult, "первого");
		System.out.println();
		
		int[] secondList = inputReader.readNumberList("Введите числа для второго списка через пробел: ");
		System.out.println();
		NumberListAnalysisResult secondResult = analysisService.analyze(secondList);
		printAnalysis(secondResult, "второго");
		System.out.println();
		
		int[] merged = analysisService.merge(firstList, secondList);
		printMerged(merged);
	}

	private void printAnalysis(NumberListAnalysisResult result, String ordinal) {
		System.out.printf("--- Анализ %s списка ---%n", ordinal);
		System.out.println("Максимальное число:     " + result.getMax());
		System.out.printf("Среднее арифметическое: %.1f%n", result.average());
		System.out.println("Отсортированный список: " + formatPrintArrays(result.sortedList()));
		System.out.println("Уникальные элементы:    " + formatPrintArrays(result.uniqueElements()));
	}

	private void printMerged(int[] merged) {
		System.out.println("Объединённый список (без дублей, по возрастанию)");
		System.out.println(formatPrintArrays(merged));
	}

	private String formatPrintArrays(int[] items) {
		 return Arrays.stream(items)
		            .mapToObj(String::valueOf)
		            .collect(Collectors.joining(" "));
	}
}
