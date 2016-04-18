import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
/*
 * Takes a list and returns the highest scoring Scrabble word
 */
public class WordCalculator {
	private static int[] arr = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8,
			5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 
			1, 4, 4, 8, 4, 10};

	public static String calculateBestWord(List<String> l) {
		String maxWord = "";
		int maxScore = 0;
		int score = 0;
		for (String word: l) {
			for (int i = 0; i < word.length(); i++) {
				char c = Character.toLowerCase(word.charAt(i));
				int index = (int)c - 97;
				score += arr[index];
			}
			if (score > maxScore) {
				maxScore = score;
				maxWord = word;
			}
			score = 0;
		}
		return maxWord;
	}
}
