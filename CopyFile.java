import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
	public static void main (String [] args) {

		try (FileInputStream input = new FileInputStream("read.pdf");
		    FileOutputStream output = new FileOutputStream("copy.pdf")) {

			int i;
			while ((i = input.read()) != -1) {
				output.write(i);
			}
			System.out.println("File copied successfully");
		    } catch (IOException e) {
			    System.out.println("Failed to copy");
			    e.printStackTrace();
		    }
	}
}
