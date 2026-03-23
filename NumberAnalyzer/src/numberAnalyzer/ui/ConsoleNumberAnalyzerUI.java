package numberAnalyzer.ui;

import java.util.List;
import java.util.stream.Collectors;

import numberAnalyzer.model.NumberListAnalysisResult;
import numberAnalyzer.service.NumberListAnalysisServiceImpl;

public class ConsoleNumberAnalyzerUI<T extends Number & Comparable<T>> {

	private final NumberListAnalysisServiceImpl<T> analysisService;
	private final ConsoleInputReader<T> inputReader;

	public ConsoleNumberAnalyzerUI(NumberListAnalysisServiceImpl<T> analysisService,
			ConsoleInputReader<T> inputReader) {
		this.analysisService = analysisService;
		this.inputReader = inputReader;
	}

	public void run() {
		System.out.println("Анализатор списков чисел\n");

		List<T> firstList = inputReader.readNumberList("Введите числа для первого списка через пробел:  ");
		System.out.println();
		printAnalysis(firstList, "первого");
		System.out.println();
		
		List<T> secondList = inputReader.readNumberList("Введите числа для второго списка через пробел: ");
		printAnalysis(secondList, "второго");
		System.out.println();
		printMerged(firstList, secondList);
	}

	private void printAnalysis(List<T> numbers, String ordinal) {
		NumberListAnalysisResult<T> result = analysisService.analyze(numbers);

		System.out.printf("--- Анализ %s списка ---%n", ordinal);
		System.out.println("Максимальное число:     " + result.max());
		System.out.printf("Среднее арифметическое: %.1f%n", result.average());
		System.out.println("Отсортированный список: " + formatList(result.sortedList()));
		System.out.println("Уникальные элементы:    " + formatList(result.uniqueElements()));
	}

	private void printMerged(List<T> first, List<T> second) {
		List<T> merged = analysisService.merge(first, second);
		System.out.println("Объединённый список (без дублей, по возрастанию)");
		System.out.println(formatList(merged));
	}

	private String formatList(List<T> items) {
		return items.stream().map(Object::toString).collect(Collectors.joining(" "));
	}
}
