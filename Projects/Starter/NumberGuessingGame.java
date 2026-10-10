/* 
    PROJECT FOCUS

    Random number, Scanner input, loops, if/else

  */

import java.util.*;

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
    private int numberOfGuesses = 0;
    private boolean play = false;
    private boolean isValid = false;
    private String response;
    private int random;
    private boolean isRight;
    private int numberOfGames = 0;

    public boolean starter() {

        if (numberOfGames < 2) {
            System.out.println("\nDo you want to play? yes(y)/no(n)\n");
        }   else {
            System.out.println("\nDo you want to play agian? yes(y)/no(n)\n");
        }

        while (!isValid) {
            response = input.handleWordInput(scanner);
            if ((response.toLowerCase().equals("yes")) || (response.toLowerCase().equals("y"))) {
                isValid = true;
                play = true;
            } else if ((response.toLowerCase().equals("no")) || (response.toLowerCase().equals("n"))) {
                System.out.println("Good bye!");
                isValid = true;
                play = false;
            } else {
                System.out.println("Please select a valid option!");
                System.out.println("Do you want to play? yes(y)/no(n)");
                isValid = false;
            }
        }

        return play;
    }

    public void setGuess (int a){
        if ((a < 1) || (a > 10)) {
            System.out.print("Number must be between 1 and 10!");
        } else  {
            guess = a;
        }
    }

    public int getGuess() {
        return guess;
    }

    public boolean compareGuess(int a, int b){
        if (a <  b) {
            System.out.print("\nNice attempt! But your guess is higher than the right number\n");
            return false;
        } else if (a > b) {
            System.out.print("\nNice attempt! But your guess is lower than the right number\n");
            return false;
        } else {
            System.out.print("\nCorrect!\n");
            return true;
        }
    }

    public void handleGame(){
        random = (int)(Math.random()*6) + 1;
        while (play) {
            System.out.print("Take a guess!");
            setGuess(input.handleIntInput(scanner));
            numberOfGuesses++;
            if (compareGuess(random, getGuess())) {
                System.out.print("You won after " + numberOfGuesses + " guess(es)!");
                play = false;
            } else {
                play = true;
            }
        }

        numberOfGuesses = 0;
        numberOfGames++;
        startGame();
    }

    public void startGame() {
        while (!play) {
                starter();
            if (starter()) {
                handleGame();
            } 
        }
    }
    
}

class InputHandler {
    Scanner scanner = new Scanner(System.in);

    public int handleIntInput (Scanner scanner){
        System.out.println("\nPlease enter a number!\n");
        while (!(scanner.hasNextInt())) {
            System.out.println("Invalid input!\nPlease enter a number!\n");
            scanner.next();
        }

        return scanner.nextInt();
    }

    public String handleWordInput (Scanner scanner){
        System.out.println("\nPlease enter a text!\n");
        while (!(scanner.hasNext())) {
            System.out.println("No entry detected!\nPlease enter a text!\n");
            scanner.next();
        }

        return scanner.next();
    }

    public String handleTextInput (Scanner scanner){
        System.out.println("\nPlease enter your text!\n");
        while (!(scanner.hasNext())) {
            System.out.println("No entry detected!\nPlease enter a text!\n");
            scanner.next();
        }

        return scanner.nextLine();
    }
}
