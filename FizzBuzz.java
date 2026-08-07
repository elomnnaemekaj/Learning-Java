import java.util.Scanner;

public class FizzBuzz {
	public static void main (String [] args) {


		Scanner scanner = new Scanner(System.in);

		System.out.print("Number: ");
		byte number = scanner.nextByte();

		String result;

		if ((number % 3 == 0) && (number % 5 == 0)){
			result = "FizzBuzz";
		}
		else if (number % 3 == 0) {
			result = "Fizz";
		}
		else if (number % 5 == 0) {
			result = "Buzz";
		}
		else {
			result = String.valueOf(number);
		}

		System.out.println(result);

		scanner.close();

	}
}
