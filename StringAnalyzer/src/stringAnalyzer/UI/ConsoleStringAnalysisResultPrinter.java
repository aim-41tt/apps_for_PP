package stringAnalyzer.UI;

import stringAnalyzer.model.StringAnalysisResult;

public class ConsoleStringAnalysisResultPrinter implements StringAnalysisResultPrinter {
	@Override
	public void print(StringAnalysisResult result) {
		System.out.println("\nРезультаты анализа:");
		System.out.printf(" Кол-во слов:              %d%n", result.getWordCount());
		System.out.printf(" Кол-во букв:              %d%n", result.getLetterCount());
		System.out.printf(" Кол-во гласных:           %d%n", result.getVowelCount());
		System.out.printf(" Кол-во согласных:         %d%n", result.getConsonantCount());
		System.out.printf(" Кол-во знаков препинания: %d%n", result.getPunctuationCount());
		System.out.printf(" Кол-во пробелов:          %d%n", result.getSpaceCount());
	}
}
