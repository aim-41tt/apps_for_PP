package numberAnalyzer.service;

import java.util.Arrays;
import java.util.stream.IntStream;

import numberAnalyzer.model.NumberListAnalysisResult;

public class NumberListAnalysisService {

	public NumberListAnalysisResult analyze(int[] numbers) {

		double average = calculateAverage(numbers);
		int[] sortedList = sortAscending(numbers);
		int[] uniqueElements = findUnique(numbers);

		return new NumberListAnalysisResult(average, sortedList, uniqueElements);
	}

	public int[] merge(int[] first, int[] second) {
		return IntStream.concat(Arrays.stream(first), Arrays.stream(second))
				  .distinct()
				  .toArray();
	}

	private double calculateAverage(int[] numbers) {
		if (numbers.length == 0) {
			throw new IllegalArgumentException("Массив пуст");
		}

		return Arrays.stream(numbers)
				.average()
				.orElseThrow(() -> new ArithmeticException("Не удалось рассчитать среднее значение"));
	}

	private int[] sortAscending(int[] numbers) {
		return Arrays.stream(numbers)
				.sorted()
				.toArray();
	}

	private int[] findUnique(int[] numbers) {
		return Arrays.stream(numbers)
				.distinct()
				.toArray();
	}
}
