import java.util.Scanner;

public class SimpleIO {
	public static void main (String [] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("What is your name?");
		String name = scanner.nextLine();
		System.out.println("How old are you?");
		int age = scanner.nextInt();
		//System.out.println("How old are you: ");
		System.out.println("\nHi, " + name + "! You will turn " + (age+1) + " next year");
	}
}
