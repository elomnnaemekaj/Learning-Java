/* 
    PROJECT FOCUS

    Random number, Scanner input, loops, if/else

*/

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class GuessingGame {
    public static void main(String[] args) {
        GameHandler game = new GameHandler();
        game.startGame();
    }
}

class GameHandler {
    Scanner scanner = new Scanner(System.in);
    InputHandler input = new InputHandler();


    private int guess;
    private int guessCount = 0;
    private boolean play = false;
    private String response;
    private int randomNumber;
    private int numberOfGames = 0;

    public boolean starter() {
        boolean isValid = false;

        if (numberOfGames == 0) {
            System.out.print("Do you want to play? yes(y)/no(n): ");
        }   else {
            System.out.print("Do you want to play again? yes(y)/no(n): ");
        }

        while (!isValid) {

            response = input.handleWordInput(scanner).toLowerCase();

            if ((response.equals("yes")) || (response.equals("y"))) {

                isValid = true;
                play = true;

            } else if ((response.equals("no")) || (response.equals("n"))) {

                System.out.println("You played " + numberOfGames + " game(s).");
                System.out.println("Good bye!");
                play = false;
                isValid = true;
                break;

            } else {

                System.out.println("\nPlease select a valid option!");
                System.out.print("Do you want to play? yes(y)/no(n): ");
                isValid = false;

            }
        }

        return play;
    }

    public boolean setGuess (int a){

        while ((a < 1) || (a > 10)) {

            System.out.println("Number must be between 1 and 10!");
            return false;

        } 
            
        guess = a;
        return true;

    }

    public int getGuess() {
        return guess;
    }

    public boolean compareGuess(int randomNumber, int guess){

        if (randomNumber <  guess) {
            System.out.println("\nNice attempt! But your guess is higher than the right number\n");
            return false;
        } else if (randomNumber > guess) {
            System.out.println("\nNice attempt! But your guess is lower than the right number\n");
            return false;
        } else {
            System.out.println("\nCorrect!\n");
            return true;
        }
    }

    public void handleGame(){
        randomNumber = ThreadLocalRandom.current().nextInt(1, 11);
        
        while (play) {

            System.out.print("Take a guess: ");

            while (!setGuess(input.handleIntInput(scanner))) {
                // Ask again if the guess is invalid
            };

            guessCount++;

            if (compareGuess(randomNumber, getGuess())) {
                System.out.print("You won after " + guessCount + " guess(es)!");
                guessCount = 0;
                numberOfGames++;
                break;
            }
        }    
    }

    public void startGame() {
            while (starter()) {
                handleGame();
            } 
    }
}

class InputHandler {
    public int handleIntInput (Scanner scanner){
        //System.out.println("\nPlease enter a number!\n");
        while (!(scanner.hasNextInt())) {
            System.out.println("Invalid input!\nPlease enter a number!\n");
            scanner.next();
        }

        return scanner.nextInt();
    }

    public String handleWordInput (Scanner scanner){
        //System.out.println("\nPlease enter a text!\n");
        while (!(scanner.hasNext())) {
            System.out.println("No entry detected!\nPlease enter a text!\n");
            scanner.next();
        }

        return scanner.next().trim();
    }

    // public String handleTextInput (Scanner scanner){
    //     System.out.println("\nPlease enter your text!\n");
    //     while (!(scanner.hasNext())) {
    //         System.out.println("No entry detected!\nPlease enter a text!\n");
    //         scanner.next();
    //     }

    //     return scanner.nextLine();
    // }
}
