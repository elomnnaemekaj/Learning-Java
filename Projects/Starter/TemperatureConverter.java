/*

  PROJECT FOCUS

    C to F, input validation

*/

import java.util.Scanner;

public class TemperatureConverter {

  public static void main(String[] args) {
    Converter converter = new Converter();
    converter.convert();
  }
}

class Converter {
  InputValidationHandler input = new InputValidationHandler();
  Scanner scanner = new Scanner(System.in);

  private boolean isRunning;
  private int option;
  private double conversionResult;
  private int trackSelection;

  public void setOption(int entry) {
    option = entry;
  }

  public int getOption() {
    return option;
  }

  public void setIsRunning(int entry) {
    if (entry == 1) {
      isRunning = true;
    } else {
      isRunning = false;
    }
  }

  public boolean getIsRunning() {
    return isRunning;
  }

  public boolean validateInput(int option) {
    if (option == 1 || option == 2) {
      return true;
    }
    trackSelection = option;
    return false;
  }

  public String handleChoice(int option) {
    if (option == 1) {
      System.out.print("Type number to convert: ");
      conversionResult = HandleConversion.celsiusToFarenheit(input.handleDoubleInput(scanner));
      return (conversionResult + "°F");
    } else {
      System.out.print("Type number to convert: ");
      conversionResult = HandleConversion.celsiusToFarenheit(input.handleDoubleInput(scanner));
      return (conversionResult + "°C");
    }
  }

  public void convert() {
    System.out.println("\nSelect an option:\n1. C to F converter\n2. F to C converter\n");
    setOption(input.handleIntInput(scanner));

    if (validateInput(getOption())) {
      System.out.println(handleChoice(getOption()));
    } else {
      System.out.println("Invalid Selection!");
    }

    setIsRunning(1);

    while (isRunning) {
      System.out.println(
          "\nSelect an option:\n1. C to F converter\n2. F to C converter\n3. Power Off\n"
      );
      setOption(input.handleIntInput(scanner));

      if (validateInput(getOption())) {
        System.out.println(handleChoice(getOption()));
        setIsRunning(1);
      } else {
        if (trackSelection == 3) {
          System.out.println("Power off!");
          setIsRunning(0);
        } else {
          System.out.println("Invalid Selection!");
          setIsRunning(1);
        }
      }
    }
  }
}

class HandleConversion {
  public static double celsiusToFarenheit(double number) {
    return (number * 1.8) + 32;
  }

  public static double farenheitToCelcius(double number) {
    return (number - 32) / 1.8;
  }
}