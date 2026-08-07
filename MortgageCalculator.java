import java.util.*;

public class MortgageCalculator {
	public static void main (String [] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Principal: ");
		int principal = scanner.nextInt();

		System.out.print("Annual Interest Rate: ");
		float rate = scanner.nextFloat();
		double annualInterestRate = rate / 1200;

		System.out.print("Period (Years): ");
		byte number = scanner.nextByte();
		int period = number * 12;

		double mortgage;

		mortgage = principal * ((annualInterestRate * Math.pow((1 + annualInterestRate), period)) / (Math.pow((1 + annualInterestRate), period) - 1));
		
		//String mortgageFormatted = NumberFormat.getCurrencyInstance();
		System.out.printf("Your mortgage is $%.2f", mortgage);

		scanner.close();

	}
}
