import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
/*
 * Tests Scrabble word calculator by printing out the highest scoring word from a list
 * of words from a text file
 */
public class ScrabbleWordTest {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("words.txt"));
			List<String> list = new LinkedList<String>();
			while(sc.hasNextLine()) {
				list.add(sc.nextLine());
			}
			System.out.println(WordCalculator.calculateBestWord(list));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
