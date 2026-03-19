package numberAnalyzer.service;

import java.util.List;

import numberAnalyzer.model.NumberListAnalysisResult;

public interface NumberListAnalysisService<T extends Number & Comparable<T>> {

	public NumberListAnalysisResult<T> analyze(List<T> numbers);
	public List<T> merge(List<T> first, List<T> second);
}
