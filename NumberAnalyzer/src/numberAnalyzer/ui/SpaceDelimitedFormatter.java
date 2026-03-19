package numberAnalyzer.ui;

import java.util.List;
import java.util.stream.Collectors;

public class SpaceDelimitedFormatter<T> implements ListFormatter<T> {

	@Override
	public String format(List<T> items) {
		return items.stream().map(Object::toString).collect(Collectors.joining(" "));
	}

}
