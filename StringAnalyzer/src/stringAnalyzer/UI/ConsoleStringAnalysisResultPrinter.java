package stringAnalyzer.UI;

import stringAnalyzer.model.StringAnalysisResult;

public class ConsoleStringAnalysisResultPrinter implements StringAnalysisResultPrinter {
	@Override
	public void print(StringAnalysisResult result) {
		System.out.println("\nРезультаты анализа:");
		System.out.printf(" Кол-во слов:              %d%n", result.wordCount());
		System.out.printf(" Кол-во букв:              %d%n", result.letterCount());
		System.out.printf(" Кол-во гласных:           %d%n", result.vowelCount());
		System.out.printf(" Кол-во согласных:         %d%n", result.consonantCount());
		System.out.printf(" Кол-во знаков препинания: %d%n", result.punctuationCount());
		System.out.printf(" Кол-во пробелов:          %d%n", result.spaceCount());
	}
}
