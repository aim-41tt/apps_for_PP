package stringAnalyzer;

import java.util.Scanner;

import stringAnalyzer.UI.ConsoleStringAnalyzerUI;
import stringAnalyzer.service.StringAnalysisService;

public class Main {

	public static void main(String[] args) {
		ConsoleStringAnalyzerUI ui = new ConsoleStringAnalyzerUI(
				new StringAnalysisService(),
				new Scanner(System.in)
		);

		ui.run();
	}
}
