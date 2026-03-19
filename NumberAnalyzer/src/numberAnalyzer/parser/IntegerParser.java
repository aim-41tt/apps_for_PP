package numberAnalyzer.parser;

import java.util.Arrays;
import java.util.List;

public class IntegerParser implements NumberParser<Integer> {

	@Override
	public List<Integer> parse(String input) {
		return Arrays.stream(input.trim().split("\\s+")).map(Integer::parseInt).toList();
	}

}
