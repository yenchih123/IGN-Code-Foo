import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Azty2QwtyTest {
	public static void main(String[] args) {
		File f1 = new File("azertyInput.txt");
		File f2 = new File("output.txt");
		convertFile(f1, f2, true);
	}

	public static void convertFile(File input, File output, boolean replaceTxt) {
		Azty2QwtyConverter converter = new Azty2QwtyConverter();
		FileWriter writer;
		try {
			Scanner sc = new Scanner(input);
			if (replaceTxt) {
				writer = new FileWriter(output);	
			} else {
				writer = new FileWriter(output, true);
			}
			PrintWriter pwriter = new PrintWriter(writer);
			String line = "";
			while(sc.hasNextLine()) {
				line = sc.nextLine();
				for (int i = 0; i < line.length(); i++) {
					pwriter.print(converter.convert2Qwty(line.charAt(i)));
				}
				pwriter.println();
			}
			pwriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
