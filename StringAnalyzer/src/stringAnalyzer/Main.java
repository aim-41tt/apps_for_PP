package stringAnalyzer;

import java.util.Scanner;

import stringAnalyzer.UI.ConsoleStringAnalyzerUI;
import stringAnalyzer.service.StringAnalysisServiceImpl;

public class Main {

	public static void main(String[] args) {
		ConsoleStringAnalyzerUI ui = new ConsoleStringAnalyzerUI(
				new StringAnalysisServiceImpl(),
				new Scanner(System.in)
		);

		ui.run();
	}
}
