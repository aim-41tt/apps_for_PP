package stringAnalyzer.counter.character;

import stringAnalyzer.counter.CharSetCounter;

public class ConsonantCounter extends CharSetCounter {

	private static final String VOWELS = "аеёиоуыьъэюяАЕЁИОУЫЬЪЭЮЯaeiouAEIOU";

	public ConsonantCounter() {
		super(VOWELS);
	}

	@Override
	protected boolean matches(char ch) {
		return Character.isLetter(ch) && !isInCharSet(ch);
	}
}