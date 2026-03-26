package numberAnalyzer.model;

import java.util.Arrays;

public record NumberListAnalysisResult(double average, int[] sortedList, int[] uniqueElements) {

	public NumberListAnalysisResult {
		sortedList = Arrays.copyOf(sortedList, sortedList.length);
		uniqueElements = Arrays.copyOf(uniqueElements, uniqueElements.length);
	}

}
