package stringAnalyzer.counter.character;

import stringAnalyzer.counter.CharSetCounter;

public class VowelCounter extends CharSetCounter {

	private static final String VOWELS = "аеёиоуыьъэюяАЕЁИОУЫЬЪЭЮЯaeiouAEIOU";

	public VowelCounter() {
		super(VOWELS);
	}

	@Override
	protected boolean matches(char ch) {
		return isInCharSet(ch);
	}

}
