import java.util.*;

public class LearnDotCom {
	
	private int [] locationCells;

	Random random = new Random();
	int randomNum = random.nextInt(0,4);
	//int[] loc = new int[] {1,2,3};
	//loc[0] = 1;
	//loc[1] = 2;
	//loc[2] = 3;

	public void setLocationCells (int[] loca) {

		locationCells = loca;

	}

	public int[] getLocationCells () {

		return locationCells;
}

	
	public static void main(String [] args) {

		int[] loc = new int[] {1,2,3};
		LearnDotCom dotcom = new LearnDotCom();
		dotcom.setLocationCells(loc);
		System.out.print(dotcom.getLocationCells());
	}
}
