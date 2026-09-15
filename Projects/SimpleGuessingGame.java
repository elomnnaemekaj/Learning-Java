import java.util.Scanner;
import java.util.regex.Pattern;

public class SimpleGuessingGame {
	public static void main (String [] args) {

	GameController controller = new GameController();
	controller.startGame();

	}
}

class GameController {

	int numOfGuesses = 0;
	boolean win = false;
	Scanner scanner = new Scanner(System.in);
	private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
	int rand = (int)(Math.random()*6) + 1;
	//System.out.println(rand);

	public boolean isNumeric(String strNum) {
    		if (strNum == null) {
        		return false;
    		}
    		return pattern.matcher(strNum).matches();
	}

	public boolean checker (int x) {
		//x.trim();
		if (x <= 0 || x >= 7){
			System.out.println("\nYou can only choose between 1 and 6!");
			return false;
		}/* else if (!isNumeric(x)){
			System.out.println("\nInvalid input");
			return false;
		}*/ else {
			return true;
		}
	}

	public void startGame () {
		//numOfGuesses = 0;
		while (numOfGuesses < 3){
			System.out.println("\nMake a guess!");
			int guess = scanner.nextInt();
			if (checker(guess)){
				if (guess == rand) {
					System.out.println("Right guess! Bravoo!!");
					win = true;
					break;
				} else {
					System.out.println("Wrong guess! Try again!!");
					numOfGuesses++;
					continue;
				}
			}
		}
		if (win){
			System.out.println("\nYou won after " + numOfGuesses + " guesses!!!");
		} else {
			System.out.println("\nYou lost! Restart game!");
		}
	}


}


