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
  private double userInput1;
  private double userInput2;
  private double resultTracker;
  private boolean power = true;
  private String error = "error";
  

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

  // public int prompt() {
  //   return input.handleIntInput(scanner);
  // }

  public void formatNumberPrint(double number){
    if (number == Math.floor(number)) {
        System.out.print((int) (number) + " " + chosenFunction + " ");
      } else {
        System.out.print(number + " " + chosenFunction + " ");
      }
  }

  public void formatResultPrint(double number){
    if (number == Math.floor(number)) {
          System.out.print("\nYour result is: " + (int) (number) + "\n");
        } else {
          System.out.print("\nYour result is: " + number + "\n");
        }
  }

  public void handleArithmeticFunctions(int choiceFunction) {
    switch (choiceFunction) {
      case 1:
        resultTracker = Arithmetic.add(getUserInput1(), getUserInput2());
        break;
      case 2:
        resultTracker = Arithmetic.subtract(getUserInput1(), getUserInput2());
        break;
      case 3:
        resultTracker = Arithmetic.multiply(getUserInput1(), getUserInput2());
        break;
      case 4:
        try {
          resultTracker = Arithmetic.divide(getUserInput1(), getUserInput2());
        } catch (Exception e) {
          error = "Cannot divide by zero";
        }
        break;
      case 5:
        try {
          resultTracker = Arithmetic.remainder(getUserInput1(), getUserInput2());
        } catch (Exception e) {
          error = "Cannot divide by zero";
        }
        break;
      case 6:
        resultTracker = resultTracker;
        break;
      default:
        System.out.println("Invalid Choice");
        break;
    }
  }
  
  public void handleChoice(int choiceFunction) {
    switch (choiceFunction) {
      case 1:
        chosenFunction = "+";
        break;
      case 2:
        chosenFunction = "-";
        break;
      case 3:
        chosenFunction = "x";
        break;
      case 4:
        chosenFunction = "÷";
        break;
      case 5:
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

  public boolean handleZeroError() {
    if ((error).equals("Cannot divide by zero")) {
      System.out.println("Math error");
      return false;
    } else {
      formatResultPrint(resultTracker);
      return true;
    }
  }

  public void calculate() {
      System.out.print("Enter number: ");
      setUserInput1(input.handleDoubleInput(scanner));

      System.out.println("\nChoose operation: \n1.Add\n2.Subtract\n3.Multipy\n4.Divide\n5.Remainder\n");
      setChoiceFunction(input.handleIntInput(scanner));

      handleChoice(getChoiceFunction());

      formatNumberPrint(getUserInput1());

      setUserInput2(input.handleDoubleInput(scanner));

      handleArithmeticFunctions(getChoiceFunction());
      power = handleZeroError();

    while (power) {
      System.out.println("\nChoose operation: \n1. Add\n2. Subtract\n3. Multipy\n4. Divide\n5. Remainder\n6. Answer/End\n");
      setUserInput1(resultTracker);

      setChoiceFunction(input.handleIntInput(scanner));
      
      handleArithmeticFunctions(getChoiceFunction());

      if (getChoiceFunction() > 0 && getChoiceFunction() < 6) {
        formatNumberPrint(getUserInput1());
        setUserInput2(input.handleDoubleInput(scanner));
        handleArithmeticFunctions(getChoiceFunction());
        
        power = handleZeroError();
      } else {
        power = handleZeroError();
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
    if (nextNumber == 0.0) {
      throw new ArithmeticException("");
    }
    return previousResult / nextNumber;
  }

  public static double remainder(double previousResult, double nextNumber) {
    if (nextNumber == 0.0) {
      throw new ArithmeticException("");
    }
    return previousResult % nextNumber;
  }

}
