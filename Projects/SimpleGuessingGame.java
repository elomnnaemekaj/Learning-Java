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
    private int rand = (int)(Math.random() * 6) + 1;
    private int numOfGuesses = 1;

    public void setInput (int i){
        input = i;
    }

    public int getInput() {
        return input;
    }

    public boolean verifyInput(){
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            setInput(scanner.nextInt());
            return true;
        } else {
            return false;
        }
    }

    public void startGame () {
        while (!prompt) {
            System.out.println("Enter a number between 1 and 6:");
            if (verifyInput()) {
                if (getInput() > 0 && getInput() < 7) {
                   if (getInput() == rand){
                        System.out.println("\nCorrect!");
                        System.out.println("You won after " + numOfGuesses + " guess(es)!");
                        prompt = true;
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
            } else {
                System.out.println("\nInvalid input!");
                numOfGuesses++;
                prompt = false;
            }
        }
    }
    
}
