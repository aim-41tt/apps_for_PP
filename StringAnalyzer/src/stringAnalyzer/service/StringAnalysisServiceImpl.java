package stringAnalyzer.service;

import stringAnalyzer.counter.CharacterCounter;
import stringAnalyzer.model.StringAnalysisResult;

public class StringAnalysisServiceImpl implements StringAnalysisService {
	private final CharacterCounter wordCounter;
	private final CharacterCounter letterCounter;
	private final CharacterCounter vowelCounter;
	private final CharacterCounter consonantCounter;
	private final CharacterCounter punctuationCounter;
	private final CharacterCounter spaceCounter;

	public StringAnalysisServiceImpl(CharacterCounter wordCounter, CharacterCounter letterCounter,
			CharacterCounter vowelCounter, CharacterCounter consonantCounter, CharacterCounter punctuationCounter,
			CharacterCounter spaceCounter) {
		this.wordCounter = wordCounter;
		this.letterCounter = letterCounter;
		this.vowelCounter = vowelCounter;
		this.consonantCounter = consonantCounter;
		this.punctuationCounter = punctuationCounter;
		this.spaceCounter = spaceCounter;
	}

	@Override
	public StringAnalysisResult analyze(String text) {
		return new StringAnalysisResult(wordCounter.count(text), letterCounter.count(text), vowelCounter.count(text),
				consonantCounter.count(text), punctuationCounter.count(text), spaceCounter.count(text));
	}
}
