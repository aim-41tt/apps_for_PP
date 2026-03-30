package numberAnalyzer.model;

import java.util.Arrays;

public record NumberListAnalysisResult(double average, int[] sortedList, int[] uniqueElements) {

	public NumberListAnalysisResult {
		sortedList = Arrays.copyOf(sortedList, sortedList.length);
		uniqueElements = Arrays.copyOf(uniqueElements, uniqueElements.length);
	}
	
	public int getMax(){
		if (sortedList.length > 0) {
			return sortedList[sortedList.length-1];
		}
		return 0;
	}

}
