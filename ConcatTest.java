public class ConcatTest {
	public static void main (String [] args) {
		int answer;
		for (int i=1; i<=12; i++){
			System.out.println(i + " times table" + "\n");
			for (int j=1; j<=12; j++){
				answer = i*j;
				System.out.println(i + "x" + j + " = " + answer);
			}
			System.out.println(""+"\n");
		}

	
	}


}
