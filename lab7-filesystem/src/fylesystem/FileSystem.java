package fylesystem;
import java.io.*;

public class FileSystem {

	public void copyFile(String filename, Output output) {
		try {
			FileReader reader = new FileReader(filename);
			output.open();

			int c;
			while ((c = reader.read()) != -1) {
				output.write((char) c);
			}

			reader.close();
			output.close();

		} catch (IOException e) {
			System.out.println("An error occurred while copying the file.");
		}
	}
}
