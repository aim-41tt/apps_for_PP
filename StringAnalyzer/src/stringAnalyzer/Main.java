package stringAnalyzer;

import java.util.Scanner;

import stringAnalyzer.UI.ConsoleStringAnalysisResultPrinter;
import stringAnalyzer.UI.ConsoleStringAnalyzerUI;
import stringAnalyzer.counter.WordCounter;
import stringAnalyzer.counter.character.ConsonantCounter;
import stringAnalyzer.counter.character.LetterCounter;
import stringAnalyzer.counter.character.PunctuationCounter;
import stringAnalyzer.counter.character.SpaceCounter;
import stringAnalyzer.counter.character.VowelCounter;
import stringAnalyzer.service.StringAnalysisService;
import stringAnalyzer.service.StringAnalysisServiceImpl;

public class Main {

	public static void main(String[] args) {
		 StringAnalysisService service = new StringAnalysisServiceImpl(
	                new WordCounter(),
	                new LetterCounter(),
	                new VowelCounter(),
	                new ConsonantCounter(),
	                new PunctuationCounter(),
	                new SpaceCounter()
	        );

	        ConsoleStringAnalyzerUI ui = new ConsoleStringAnalyzerUI(
	                service,
	                new ConsoleStringAnalysisResultPrinter(),
	                new Scanner(System.in)
	        );

	        ui.run();}

}
