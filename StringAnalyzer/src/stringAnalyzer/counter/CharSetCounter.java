package stringAnalyzer.counter;

public abstract class CharSetCounter implements CharacterCounter {

	private final String charSet;

	public CharSetCounter(String charSet) {
		this.charSet = charSet;
	}

	@Override
	public int count(String text) {
		int count = 0;
		for (char ch : text.toCharArray()) {
			if (matches(ch)) {
				count++;
			}
		}
		return count;
	}

	protected boolean isInCharSet(char ch) {
		return charSet.indexOf(ch) > 0;
	}

	protected abstract boolean matches(char ch);
}
