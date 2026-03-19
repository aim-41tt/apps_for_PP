package numberAnalyzer;

import numberAnalyzer.parser.IntegerParser;
import numberAnalyzer.service.NumberListAnalysisServiceImpl;
import numberAnalyzer.ui.ConsoleInputReader;
import numberAnalyzer.ui.ConsoleNumberAnalyzerUI;
import numberAnalyzer.ui.SpaceDelimitedFormatter;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		ConsoleNumberAnalyzerUI<Integer> ui = new ConsoleNumberAnalyzerUI<>(new NumberListAnalysisServiceImpl<>(),
				new ConsoleInputReader<>(scanner, new IntegerParser()), new SpaceDelimitedFormatter<>());

		ui.run();

		scanner.close();
	}
}
