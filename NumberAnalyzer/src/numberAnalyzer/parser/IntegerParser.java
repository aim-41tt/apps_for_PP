package numberAnalyzer.parser;

import java.util.Arrays;

public class IntegerParser {

	public int[] parse(String input) {
		return Arrays.stream(input.trim().split("\\s+"))
				.mapToInt(Integer::parseInt)
				.toArray();
	}

}
