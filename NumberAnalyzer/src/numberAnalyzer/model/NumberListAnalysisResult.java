package numberAnalyzer.model;

import java.util.List;

public record NumberListAnalysisResult<T extends Number & Comparable<T>>(T max, double average, List<T> sortedList,
		List<T> uniqueElements) {

	public NumberListAnalysisResult {
		sortedList = List.copyOf(sortedList);
		uniqueElements = List.copyOf(uniqueElements);
	}
}
