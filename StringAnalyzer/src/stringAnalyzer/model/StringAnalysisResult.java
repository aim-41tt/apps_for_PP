package stringAnalyzer.model;

public class StringAnalysisResult {

	private final int wordCount;
	private final int letterCount;
	private final int vowelCount;
	private final int consonantCount;
	private final int punctuationCount;
	private final int spaceCount;

	public StringAnalysisResult(int wordCount, int letterCount, int vowelCount, int consonantCount,
			int punctuationCount, int spaceCount) {
		this.wordCount = wordCount;
		this.letterCount = letterCount;
		this.vowelCount = vowelCount;
		this.consonantCount = consonantCount;
		this.punctuationCount = punctuationCount;
		this.spaceCount = spaceCount;
	}

	/**
	 * @return the wordCount
	 */
	public int getWordCount() {
		return wordCount;
	}

	/**
	 * @return the letterCount
	 */
	public int getLetterCount() {
		return letterCount;
	}

	/**
	 * @return the vowelCount
	 */
	public int getVowelCount() {
		return vowelCount;
	}

	/**
	 * @return the consonantCount
	 */
	public int getConsonantCount() {
		return consonantCount;
	}

	/**
	 * @return the punctuationCount
	 */
	public int getPunctuationCount() {
		return punctuationCount;
	}

	/**
	 * @return the spaceCount
	 */
	public int getSpaceCount() {
		return spaceCount;
	}

}
