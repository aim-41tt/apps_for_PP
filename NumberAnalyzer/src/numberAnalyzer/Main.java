package numberAnalyzer;

import numberAnalyzer.parser.IntegerParser;
import numberAnalyzer.service.NumberListAnalysisService;
import numberAnalyzer.ui.ConsoleInputReader;
import numberAnalyzer.ui.ConsoleNumberAnalyzerUI;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		ConsoleNumberAnalyzerUI ui = new ConsoleNumberAnalyzerUI(
				new NumberListAnalysisService(),
				new ConsoleInputReader(scanner, new IntegerParser()));

		ui.run();

		scanner.close();
	}
}
