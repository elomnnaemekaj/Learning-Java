/*

  PROJECT FOCUS

  methods, switch, error handling for divide by zero

*/

import java.util.Scanner;

public class SimpleConsoleCalculator {

  public static void main(String[] args) {
    Calculator calculator = new Calculator();
  }
}

class Calculator {
  Scanner scanner = new Scanner(System.in);
  InputValidationHandler input = new InputValidationHandler();

  private int choiceFunction;
  private double userInput;
  private double resultTracker;
  private boolean power = true;

  public void setUserInput(double entry) {
    userInput = entry;
  }

  public double getUserInput() {
    return userInput;
  }

  public void prompt() {
    System.out.print("Type a number: ");
    setUserInput(input.handleDoubleInput(scanner));
  }

  public void handleArithmeticFunctions() {
    System.out.println("Choose operation: \n1.Add\n2.Subtract\n3.Multipy\n4.Divide\n5.Remainder\n");
    choiceFunction = input.handleIntInput(scanner);
    // if (choiceFunction == 1) {
    //   resultTracker = Arithmetic.add(resultTracker, getUserInput());
    // }
    switch (choiceFunction) {
      case 1:
        resultTracker = Arithmetic.add(resultTracker, getUserInput());
        break;
      case 2:
        resultTracker = Arithmetic.subtract(resultTracker, getUserInput());
        break;
      case 3:
        resultTracker = Arithmetic.multiply(resultTracker, getUserInput());
        break;
      case 4:
        resultTracker = Arithmetic.divide(resultTracker, getUserInput());
        break;
      case 5:
        resultTracker = Arithmetic.remainder(resultTracker, getUserInput());
        break;
      default:
        break;
    }
  }

  public void calculate() {
    int initialState = 0;

    while (power) {
      System.out.print("First number");
      
    }
  }

}

class Arithmetic {
  public static double add(double previousResult, double nextNumber) {
    return previousResult + nextNumber;
  }

  public static double subtract(double previousResult, double nextNumber) {
    return previousResult - nextNumber;
  }

  public static double multiply(double previousResult, double nextNumber) {
    return previousResult * nextNumber;
  }

  public static double divide(double previousResult, double nextNumber) {
    return previousResult / nextNumber;
  }

  public static double remainder(double previousResult, double nextNumber) {
    return previousResult % nextNumber;
  }

}