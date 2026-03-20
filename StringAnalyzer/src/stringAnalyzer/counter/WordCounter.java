package stringAnalyzer.counter;

public class WordCounter implements CharacterCounter {

	@Override
	public int count(String text) {
		String trimmed = text.trim();
		if (trimmed.isEmpty()) {
			return 0;
		}
		return trimmed.split("\\s+").length;
	}

}
