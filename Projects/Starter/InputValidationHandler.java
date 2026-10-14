import java.util.Scanner;

public class InputValidationHandler {
    public int handleIntInput(Scanner scanner) {
        while (!(scanner.hasNextInt())) {
            System.out.println("Invalid input!\nPlease enter a number!\n");
            scanner.next();
        }

        return scanner.nextInt();
    }
    
    public double handleDoubleInput(Scanner scanner) {
        while (!(scanner.hasNextDouble())) {
            System.out.println("Invalid input!\nPlease enter a number!\n");
            scanner.next();
        }

        return scanner.nextDouble();
    }

    public String handleWordInput (Scanner scanner){
        while (!(scanner.hasNext())) {
            System.out.println("No entry detected!\nPlease enter a text!\n");
            scanner.next();
        }

        return scanner.next().trim();
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
