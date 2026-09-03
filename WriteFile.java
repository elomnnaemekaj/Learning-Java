import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFile {
	public static void main (String [] args) {

		String text = "Hello, world";

		try (FileOutputStream output = new FileOutputStream("helloworld.txt")){
			output.write(text.getBytes());
			System.out.println("Wrote on file successfully");
		} catch (IOException e) {
			System.out.println("Failed to write on file");
			e.printStackTrace();
		}
	}
}
