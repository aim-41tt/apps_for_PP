package stringAnalyzer;

import java.util.Scanner;

import stringAnalyzer.UI.ConsoleStringAnalyzerUI;
import stringAnalyzer.service.StringAnalysisService;

public class Main {

	public static void main(String[] args) {

		StringAnalysisService analysisService = new StringAnalysisService();

		try (Scanner scanner = new Scanner(System.in)) {
			ConsoleStringAnalyzerUI ui = new ConsoleStringAnalyzerUI(analysisService, scanner);
			ui.run();
		}

	}
}
