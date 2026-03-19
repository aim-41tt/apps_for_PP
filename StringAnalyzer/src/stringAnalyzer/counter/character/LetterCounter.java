package stringAnalyzer.counter.character;

import stringAnalyzer.counter.CharacterCounter;

public class LetterCounter implements CharacterCounter {

	@Override
	public int count(String text) {
		int count = 0;
		for (char ch : text.toCharArray()) {
			if (Character.isLetter(ch)) {
				count++;
			}
		}
		return count;
	}
}
