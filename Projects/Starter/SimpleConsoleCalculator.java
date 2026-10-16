/*

  PROJECT FOCUS

  methods, switch, error handling for divide by zero

*/

import java.util.Scanner;

public class SimpleConsoleCalculator {

  public static void main(String[] args) {
    Calculator calculator = new Calculator();
    calculator.calculate();
  }
}

class Calculator {
  Scanner scanner = new Scanner(System.in);
  InputValidationHandler input = new InputValidationHandler();

  private int choiceFunction;
  private String chosenFunction;
  private double userInput1 = 0;
  private double userInput2 = 0;
  private double resultTracker;
  private boolean power = true;
  

  public void setUserInput1(double entry) {
    userInput1 = entry;
  }

  public double getUserInput1() {
    return userInput1;
  }

  public void setUserInput2(double entry) {
    userInput2 = entry;
  }

  public double getUserInput2() {
    return userInput2;
  } 


  public void setChoiceFunction(int entry) {
    choiceFunction = entry;
  }

  public int getChoiceFunction() {
    return choiceFunction;
  } 

  public double prompt() {
    return input.handleDoubleInput(scanner);
  }



  public void handleArithmeticFunctions(int choiceFunction) {
    switch (choiceFunction) {
      case 1:
        resultTracker = Arithmetic.add(getUserInput1(), getUserInput2());
        chosenFunction = "+";
        break;
      case 2:
        resultTracker = Arithmetic.subtract(getUserInput1(), getUserInput2());
        chosenFunction = "-";
        break;
      case 3:
        resultTracker = Arithmetic.multiply(getUserInput1(), getUserInput2());
        chosenFunction = "x";
        break;
      case 4:
        resultTracker = Arithmetic.divide(getUserInput1(), getUserInput2());
        chosenFunction = "÷";
        break;
      case 5:
        resultTracker = Arithmetic.remainder(getUserInput1(), getUserInput2());
        chosenFunction = "%";
        break;
      case 6:
        resultTracker = resultTracker;
        break;
      default:
        System.out.println("Invalid Choice");
        break;
    }
  }

  public void calculate() {
      System.out.print("Enter number: ");
      setUserInput1(prompt());
      System.out.println("\nChoose operation: \n1.Add\n2.Subtract\n3.Multipy\n4.Divide\n5.Remainder\n");
      setChoiceFunction((int)(prompt()));
      handleArithmeticFunctions(getChoiceFunction());
      if (getUserInput1() == Math.floor(getUserInput1())) {
        System.out.print((int) (getUserInput1()) + " " + chosenFunction + " ");
      } else {
        System.out.println(getUserInput1());
      }
      setUserInput2(prompt());
      handleArithmeticFunctions(getChoiceFunction());
      if (resultTracker == Math.floor(resultTracker)) {
          System.out.println("\nYour result is: " + (int) (resultTracker) + "\n");
        } else {
          System.out.println("\nYour result is: " + resultTracker + "\n");
        }      
    while (power) {
      System.out.println("\nChoose operation: \n1. Add\n2. Subtract\n3. Multipy\n4. Divide\n5. Remainder\n6. Answer/End\n");
      setUserInput1(resultTracker);
      setChoiceFunction((int)(prompt()));
      handleArithmeticFunctions(getChoiceFunction());
      if (getChoiceFunction() > 0 && getChoiceFunction() < 6) {
        if (getUserInput1() == Math.floor(getUserInput1())) {
        System.out.print((int) (getUserInput1()) + " " + chosenFunction + " ");
      } else {
        System.out.println(getUserInput1());
      }
      setUserInput2(prompt());
      handleArithmeticFunctions(getChoiceFunction());
        if (resultTracker == Math.floor(resultTracker)) {
          System.out.println("\nYour result is: " + (int) (resultTracker) + "\n");
        } else {
          System.out.println("\nYour result is: " + resultTracker + "\n");
        }
        power = true;
      } else {
        if (resultTracker == Math.floor(resultTracker)) {
          System.out.println("\nYour result is: " + (int) (resultTracker) + "\n");
        } else {
          System.out.println("\nYour result is: " + resultTracker + "\n");
        }
        power = false;
      }
      
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
