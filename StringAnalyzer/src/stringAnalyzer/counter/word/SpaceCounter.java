package stringAnalyzer.counter.word;

import stringAnalyzer.counter.CharacterCounter;

public class SpaceCounter implements CharacterCounter {
	@Override
	public int count(String text) {
		int count = 0;
		for (char ch : text.toCharArray()) {
			if (ch == ' ') {
				count++;
			}
		}
		return count;
	}
}
