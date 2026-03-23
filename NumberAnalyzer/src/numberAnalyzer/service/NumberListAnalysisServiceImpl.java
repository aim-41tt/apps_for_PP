package numberAnalyzer.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import numberAnalyzer.model.NumberListAnalysisResult;

public class NumberListAnalysisServiceImpl<T extends Number & Comparable<T>> {

	public NumberListAnalysisResult<T> analyze(List<T> numbers) {

		T max = findMax(numbers);
		double average = calculateAverage(numbers);
		List<T> sortedList = sortAscending(numbers);
		List<T> uniqueElements = findUnique(numbers);

		return new NumberListAnalysisResult<T>(max, average, sortedList, uniqueElements);
	}

	public List<T> merge(List<T> first, List<T> second) {
		Set<T> merged = new LinkedHashSet<>(first);
		merged.addAll(second);
		return merged.stream().sorted().toList();
	}

	private T findMax(List<T> numbers) {
		return numbers.stream().max(Comparator.naturalOrder())
				.orElseThrow(() -> new NoSuchElementException("Список пуст!"));
	}

	private double calculateAverage(List<T> numbers) {
		return numbers.stream().mapToDouble(Number::doubleValue).average()
				.orElseThrow(() -> new NoSuchElementException("Список пуст!"));
	}

	private List<T> sortAscending(List<T> numbers) {
		return numbers.stream().sorted().toList();
	}

	private List<T> findUnique(List<T> numbers) {
		return new ArrayList<T>(new LinkedHashSet<T>(numbers));
	}
}
