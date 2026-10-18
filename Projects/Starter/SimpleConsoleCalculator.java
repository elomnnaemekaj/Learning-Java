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
  private boolean isRunning = true;
  private String errorMessage = "";
  

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
     try {
        switch (choiceFunction) {
            case 1:
                resultTracker = Arithmetic.add(
                    getUserInput1(), getUserInput2());
                break;

            case 2:
                resultTracker = Arithmetic.subtract(
                    getUserInput1(), getUserInput2());
                break;

            case 3:
                resultTracker = Arithmetic.multiply(
                    getUserInput1(), getUserInput2());
                break;

            case 4:
                resultTracker = Arithmetic.divide(
                    getUserInput1(), getUserInput2());
                break;

            case 5:
                resultTracker = Arithmetic.remainder(
                    getUserInput1(), getUserInput2());
                break;

            default:
                System.out.println("Invalid Choice");
                return;
        }

        errorMessage = "";

    } catch (ArithmeticException e) {
        errorMessage = e.getLocalizedMessage();
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
      default:
        break;
    }
  }

  public boolean handleCalculationResult(int arg) {
     if (!errorMessage.isEmpty()) {
        System.out.println("Math error: " + errorMessage);
        errorMessage = "";
        return false;
    }

    if (arg >= 1 && arg <= 5) {
        formatResultPrint(resultTracker);
        return true;
    }

    return false;
  }

  public void calculate() {
    int wrongChoice = 0;
      System.out.print("Enter number: ");
      setUserInput1(input.handleDoubleInput(scanner));

      System.out.println("\nChoose operation: \n1.Add\n2.Subtract\n3.Multipy\n4.Divide\n5.Remainder\n6. End\n");
      setChoiceFunction(input.handleIntInput(scanner));
      if (choiceFunction == 6) {
        System.out.print("Power Off!");
        System.exit(0);
      }

      handleChoice(getChoiceFunction());
      if ((choiceFunction >= 1 && choiceFunction <= 5)) {
        formatNumberPrint(getUserInput1());

        setUserInput2(input.handleDoubleInput(scanner));

        handleArithmeticFunctions(getChoiceFunction());
        isRunning = handleCalculationResult(getChoiceFunction());
      } else {
        resultTracker = getUserInput1();
        System.out.print("Invalid Choice! Try again!");
        wrongChoice++;
        isRunning = true;
      }

    while (isRunning) {
      System.out.println("\nChoose operation: \n1. Add\n2. Subtract\n3. Multipy\n4. Divide\n5. Remainder\n6. End\n");
      setUserInput1(resultTracker);

      setChoiceFunction(input.handleIntInput(scanner));
      if (choiceFunction == 6) {
        System.out.print("Power Off!");
        System.exit(0);
      }
      handleChoice(getChoiceFunction());

      if (getChoiceFunction() > 0 && getChoiceFunction() < 6) {
        formatNumberPrint(getUserInput1());
        setUserInput2(input.handleDoubleInput(scanner));
        handleArithmeticFunctions(getChoiceFunction()); 
        isRunning = handleCalculationResult(getChoiceFunction());
        wrongChoice = 0;
      } else {
        if (wrongChoice < 1) {
          System.out.print("Invalid Choice! Try again!");
          wrongChoice++;
          isRunning = true;
        } else{
          System.out.print("Power Off!");
          isRunning = false;
        }
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
        throw new ArithmeticException("Cannot divide by zero");
    }
    return previousResult / nextNumber;
  }

  public static double remainder(double previousResult, double nextNumber) {
    if (nextNumber == 0.0) {
        throw new ArithmeticException("Cannot find remainder by zero");
    }
    return previousResult % nextNumber;
  }

}
