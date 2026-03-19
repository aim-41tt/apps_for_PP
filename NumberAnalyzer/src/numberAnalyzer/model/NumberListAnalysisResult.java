package numberAnalyzer.model;

import java.util.List;

public class NumberListAnalysisResult<T extends Number & Comparable<T>> {

	private final T max;
	private final double average;
	private final List<T> sortedList;
	private final List<T> uniqueElements;

	public NumberListAnalysisResult(T max, double average, List<T> sortedList, List<T> uniqueElements) {
		this.max = max;
		this.average = average;
		this.sortedList = List.copyOf(sortedList);
		this.uniqueElements = List.copyOf(uniqueElements);
	}

	/**
	 * @return the max
	 */
	public T getMax() {
		return max;
	}

	/**
	 * @return the average
	 */
	public double getAverage() {
		return average;
	}

	/**
	 * @return the sortedList
	 */
	public List<T> getSortedList() {
		return sortedList;
	}

	/**
	 * @return the uniqueElements
	 */
	public List<T> getUniqueElements() {
		return uniqueElements;
	}

}
