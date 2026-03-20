package stringAnalyzer.model;

public record StringAnalysisResult(int wordCount, int letterCount, int vowelCount, int consonantCount,
		int punctuationCount, int spaceCount) {
}
