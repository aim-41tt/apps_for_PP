package numberAnalyzer.ui;

import java.util.List;

import numberAnalyzer.model.NumberListAnalysisResult;
import numberAnalyzer.service.NumberListAnalysisService;

public class ConsoleNumberAnalyzerUI<T extends Number & Comparable<T>> {

    private final NumberListAnalysisService<T> analysisService;
    private final ConsoleInputReader<T>        inputReader;
    private final ListFormatter<T>             formatter;

    public ConsoleNumberAnalyzerUI(
            NumberListAnalysisService<T> analysisService,
            ConsoleInputReader<T> inputReader,
            ListFormatter<T> formatter
    ) {
        this.analysisService = analysisService;
        this.inputReader     = inputReader;
        this.formatter       = formatter;
    }

    public void run() {
        System.out.println("Анализатор списков чисел\n");

        List<T> firstList  = inputReader.readNumberList("Введите числа для первого списка через пробел:  ");
        List<T> secondList = inputReader.readNumberList("Введите числа для второго списка через пробел: ");

        System.out.println();
        printAnalysis(firstList, "первого");
        System.out.println();
        printAnalysis(secondList, "второго");
        System.out.println();
        printMerged(firstList, secondList);
    }

    private void printAnalysis(List<T> numbers, String ordinal) {
        NumberListAnalysisResult<T> result = analysisService.analyze(numbers);

        System.out.printf("--- Анализ %s списка ---%n", ordinal);
        System.out.println("Максимальное число:     " + result.getMax());
        System.out.printf("Среднее арифметическое: %.1f%n", result.getAverage());
        System.out.println("Отсортированный список: " + formatter.format(result.getSortedList()));
        System.out.println("Уникальные элементы:    " + formatter.format(result.getUniqueElements()));
    }

    private void printMerged(List<T> first, List<T> second) {
        List<T> merged = analysisService.merge(first, second);
        System.out.println("Объединённый список (без дублей, по возрастанию)");
        System.out.println(formatter.format(merged));
    }
}
