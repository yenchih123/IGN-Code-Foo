import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCalculator {
	private static int[] arr = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8,
	                     5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 
	                     1, 4, 4, 8, 4, 10};
	
	public static String calculateBestWord(File f) throws FileNotFoundException {
		String maxWord = "";
		int maxScore = 0;
		Scanner sc = new Scanner(f);
		String word = "";
		int score;
		while(sc.hasNextLine()) {
			score = 0;
			word = sc.nextLine();
			for (int i = 0; i < word.length(); i++) {
				char c = Character.toLowerCase(word.charAt(i));
				int index = (int)c - 97;
				score += arr[index];
			}
			if (score > maxScore) {
				maxScore = score;
				maxWord = word;
			}
		}
		return maxWord;
	}
}
