package stringAnalyzer.counter.character;

import stringAnalyzer.counter.CharSetCounter;

public class PunctuationCounter extends CharSetCounter {
	private static final String PUNCTUATION = ".,!?;:—–-()[]{}\"'«»…";

	public PunctuationCounter() {
		super(PUNCTUATION);
	}

	@Override
	protected boolean matches(char ch) {
		return isInCharSet(ch);
	}
}
