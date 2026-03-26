package numberAnalyzer.service;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import numberAnalyzer.model.NumberListAnalysisResult;

public class NumberListAnalysisService {

	public NumberListAnalysisResult analyze(int[] numbers) {

		double average = calculateAverage(numbers);
		int[] sortedList = sortAscending(numbers);
		int[] uniqueElements = findUnique(numbers);

		return new NumberListAnalysisResult(average, sortedList, uniqueElements);
	}

	public int[] merge(int[] first, int[] second) {
		Set<Integer> merged = new TreeSet<>();

		for (int n : first) merged.add(n);
		for (int n : second) merged.add(n);

		return merged.stream().mapToInt(Integer::intValue).toArray();
	}

	private double calculateAverage(int[] numbers) {
		if (numbers.length == 0) {
			throw new IllegalArgumentException("Массив пуст");
		}

		return Arrays.stream(numbers)
				.average()
				.orElseThrow();
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
