import java.util.*;

public class Speeding {

	public static void main (String [] args) {
	
		int[] vehicles = {61, 81, 74, 88, 65, 71, 68};
		System.out.println(Arrays.toString(speeding(vehicles, 70)));
	}

	static int[] speeding (int[] vehicles, int limit) {

		int count = 0;
		int overspeeding = 0;
		int averageOverspeeding;
		
		for (int vehicle : vehicles) {

			if (vehicle > limit) {
				count += 1;
				overspeeding += (vehicle - limit);
			}
		}

//		if (overspeeding == 0)
//			averageOverspeeding = 0;
//		else
//			averageOverspeeding = overspeeding/count;

		averageOverspeeding = (overspeeding < 1) ? 0 : overspeeding/count;

		int[] result = {count, averageOverspeeding};

		return result;
	}
}


