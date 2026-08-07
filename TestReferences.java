import java.awt.*;
import java.util.*;

public class TestReferences {
	public static void main (String [] args) {
		String message = new String("Hello World!");
		String testMessage = message;
		message = "Hello Java!";

		Point firstPoint = new Point(2,1);
		Point secondPoint = firstPoint;
		firstPoint.y = 2;
		secondPoint.y = 3;

		System.out.println(testMessage + "\n");
		System.out.println(firstPoint);
		System.out.println(secondPoint + "\n");

		message.replace("Java!", "JVM!");

		System.out.println(testMessage);
		System.out.println(message + "\n");

		int [] numbers1 = new int [5];
		int [] numbers2 = numbers1;
		numbers1[1] = 25;
		numbers1[4] = 40;
		numbers2[0] = 7;
		numbers2[3] = 33;
		numbers1[1] = 20;
		numbers1[0] = 10;


		System.out.println(numbers1);
		System.out.println(numbers2);
		System.out.println(Arrays.toString(numbers1));
		System.out.println(Arrays.toString(numbers2));

	}
}
