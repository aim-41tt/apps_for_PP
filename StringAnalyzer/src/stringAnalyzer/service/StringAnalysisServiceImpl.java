package stringAnalyzer.service;

import java.util.BitSet;

import stringAnalyzer.model.StringAnalysisResult;

public class StringAnalysisServiceImpl {

	private static final BitSet VOWELS = toBitSet("аеёиоуыэюяАЕЁИОУЫЭЮЯaeiouAEIOU");
	private static final BitSet SIGNS = toBitSet("ьъЬЪ");
	private static final BitSet PUNCTUATION = toBitSet(".,!?;:—–-()[]{}\"'«»…");

	private static BitSet toBitSet(String chars) {
		BitSet bitSet = new BitSet();
		for (char ch : chars.toCharArray()) {
			bitSet.set(ch);
		}
		return bitSet;
	}

	public StringAnalysisResult analyze(String text) {
		int words = 0;
		int letters = 0;
		int vowels = 0;
		int consonants = 0;
		int punctuation = 0;
		int spaces = 0;

		boolean inWord = false;

		for (char ch : text.toCharArray()) {
			if (ch == ' ') {
				spaces++;
				inWord = false;
			} else if (Character.isWhitespace(ch)) {
				inWord = false;
			} else {
				if (!inWord) {
					words++;
					inWord = true;
				}

				if (VOWELS.get(ch)) {
					letters++;
					vowels++;
				} else if (Character.isLetter(ch)) {
					letters++;
					if (!SIGNS.get(ch)) {
						consonants++;
					}
				} else if (PUNCTUATION.get(ch)) {
					punctuation++;
				}
			}
		}

		return new StringAnalysisResult(words, letters, vowels, consonants, punctuation, spaces);
	}
}
