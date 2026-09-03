public class AverageAge {
	public static void main (String [] args) {

		int  [] studentsAge = {22,23,26,21,30,28,25};
		int counter = 0;

		for (int student : studentsAge) {
			counter += student;
		}

		System.out.println("Students age average = " + (counter/studentsAge.length));

	}
}
