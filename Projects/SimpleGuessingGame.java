import java.util.Scanner;

public class SimpleGuessingGame {
    public static void main(String[] args) {
        GameController start = new GameController();
        start.startGame();
    }
}

class GameController {
    private int input;
    private boolean prompt = false;
    private int numOfGuesses = 1;
    private int numOfGames = 0;
    private boolean verifier = false;
    private int rand;

    public void setInput (int i){
        input = i;
    }

    public int getInput() {
        return input;
    }

    public void setVerifier (boolean b){
        verifier = b;
    }

    public boolean getVerifier() {
        return verifier;
    }

   public void verifyPrompt(){
        Scanner scanner = new Scanner(System.in);      
        String response;
        
        while (!verifier) { 
            if (numOfGames == 0) {
                System.out.println("\nDo you want to play? Yes(Y)/No(N)");
            } else {
                System.out.println("\nDo you want to play again? Yes/No");
            }

            response = scanner.next();
            response = response.trim().toLowerCase();

            if((response.equals("yes")) || (response.equals("y"))) {
                rand = (int)(Math.random() * 6) + 1;
                prompt = false;
                numOfGuesses = 0;
                verifier = true;
            } else if ((response.equals("no")) || (response.equals("n"))) {
                prompt = true;
                System.out.println("Goodbye!");
                break;
            } else if (response.equals("")) {
                System.out.println("\nPlease enter Yes or No");
                verifier = false;
            } else {
                System.out.println("\nPlease enter Yes or No");
                verifier = false;
            }
        }
    }

	public int getValidNum(Scanner scanner) {
		while (!scanner.hasNextInt()) {
			System.out.println("\nInvalid input. Enter a number:");
			scanner.next();
		}
		return scanner.nextInt();
	}

    public void startGame () {
        while (!prompt) {

            verifyPrompt();

            if (verifier == false) {
                break;
            }

            System.out.println("\nEnter a number between 1 and 6:");
            
            setInput(getValidNum(new Scanner(System.in)));
            
            if (getInput() > 0 && getInput() < 7) {
                if (getInput() == rand){
                    System.out.println("\nCorrect!");
                    System.out.println("You won after " + numOfGuesses + " guess(es)!");
		            numOfGames++;
                    verifier = false;
                } else {
                    System.out.println("Wrong guess!");
                    numOfGuesses++;
                    prompt = false;
                }
            } else {
                
                System.out.println("\nInput must be betwen 1 and 6");
                numOfGuesses++;
                prompt = false;
            }
        }

    }
    
}
