import java.io.*;

public class CreateFile {

	public static void main (String [] args) {

		try {
			File file = new File("Students List.txt");
			if(file.createNewFile()){
				System.out.println(file.getName() + " created successfully");
			} else {
				System.out.println(file.getName() + " already exists");
			}
		} catch (IOException e) {
			System.out.println("Something went wrong: " + e);
		}
	}
}
