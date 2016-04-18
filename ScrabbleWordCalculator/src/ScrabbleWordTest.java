import java.io.File;
import java.io.FileNotFoundException;
/*
 * Tests Scrabble word calculator by printing out the highest scoring word
 */
public class ScrabbleWordTest {
	public static void main(String[] args) {
		try {
			System.out.println(WordCalculator.calculateBestWord(new File("words.txt")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
