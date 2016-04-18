import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * Converts an AZERTY character into a QWERTY character
 * utilizing a hashtable
 */
public class Azty2QwtyConverter {
	private char[] arr;
	private int arraySize = 219;

	public Azty2QwtyConverter() {
		arr = new char[arraySize];
		fillTable();
	}
	
	//Add key value pair to array
	private void addConverts(char azrty, char qwrty) {
		int hash = hashFunction(azrty);
		if (arr[hash] == '\u0000') {
			arr[hash] = qwrty;
		} else {
			System.out.println(hash);
			System.out.println("THIS IS BAD HASH - CHANGE");
		}
	}
	
	//Returns the index in which the value will be stored
	private int hashFunction(char key){
		String hex = Integer.toHexString(key | 0x1000).substring(1);
		int digits = hex.length();
		int decimal = 0;
		for (int i = 0; i < digits; i++) {
			decimal += Character.getNumericValue(hex.charAt(i)) * Math.pow(16, digits - (i + 1));
		}
		return decimal % arraySize;
	}
	
	//Fills out converter table according to the conversion text file
	private void fillTable() {
		Scanner sc;
		try {
			sc = new Scanner(new File("conversion.txt"));
			String[] split = null;
			while(sc.hasNextLine()) {
				split = sc.nextLine().split(" ");
				addConverts((char)Integer.parseInt(split[0], 16), 
						(char)Integer.parseInt(split[1], 16));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	//Converts an azerty char input into its qwerty equivalent
	public char convert2Qwty(char c) {
		int hash = hashFunction(c);
		char output = arr[hash];
		if (output == '\u0000') {
			return ' ';
		}
		return output;	
	}
}
