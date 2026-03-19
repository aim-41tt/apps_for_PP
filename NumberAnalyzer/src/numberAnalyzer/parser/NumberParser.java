package numberAnalyzer.parser;

import java.util.List;

public interface NumberParser<T extends Number> {
	List<T> parse(String input);
}
