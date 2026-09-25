import java.util.*;

public class StudentAverage {
	public static void main (String [] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter student name");
		String studentName = scanner.nextLine();
		StudentAverageController studentAverage = new StudentAverageController();
		studentAverage.getStudentAverage();
		System.out.println("\n" + studentName + "'s average is " + studentAverage.getAverage());
	}
}

class StudentAverageController {

		private int myInt;
		private double average;

		public int getMyInt() {
			return myInt;
		}

		public void setMyInt(int num) {
			myInt = num;
		}

		public double getAverage() {
			return average;
		}

		public void setAverage(double a) {
			average = a;
		}

		Scanner scanner = new Scanner(System.in);

		public int getNum(Scanner scanner){
			//System.out.println("\nEnter a number:");
			while (!scanner.hasNextInt()){
				System.out.println("\nInvalid input. Please enter a number:");
				scanner.next();
			}
			
			return scanner.nextInt();
		}
		
		public void getStudentAverage () {
			System.out.println("\nHow many subjects does the student take?");
			
			int numOfSubjects = getNum(new Scanner(System.in));

			while (numOfSubjects < 1) {
				System.out.println("\nNumber of subjects cannot be less than 1");
				numOfSubjects = getNum(new Scanner(System.in));
			}
			
			double [] scores = new double[numOfSubjects];
			double score;
			double total = 0;

			for (int i = 0; i < numOfSubjects; i++) {
				System.out.println("\nEnter student score for subject " + (i+1));
				score = getNum(new Scanner(System.in));
				scores[i] = score;
				System.out.println(Arrays.toString(scores));
				total += score;
			}

			if (total == 0) {
				setAverage(0.0);
			} else {
				setAverage(total/numOfSubjects);
			}
		}
		
}
