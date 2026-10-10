import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Base10Converter {
    public static void main(String[] args) {
        Converter converter = new Converter();
	Scanner scanner = new Scanner(System.in);
	System.out.println("What would you like to do? Select\n1: Convert from Base 10\n2: Convert to Base 10");
	
	int choice = scanner.nextInt();
    if (choice == 1) {
        System.out.println("\nWhat base do you want to convert to?\n");
        int base = scanner.nextInt();
        System.out.println("\nWhat number do you want to convert?\n");
        int num = scanner.nextInt();
        System.out.println(converter.convertFromBase10(base, num));
       } else if (choice == 2) {
        System.out.println("\nWhat base do you want to convert from?\n");
        int base = scanner.nextInt();
        System.out.println("\nWhat number do you want to convert?\n");
        int num = scanner.nextInt();
        System.out.println(converter.convertToBase10(base, num));
       }
              
       
    }
}

class Converter {
    String remainder;
    ArrayList container = new ArrayList<String>();

    public String  convertFromBase10 (int base, int num){
        while (num != 0) {
            remainder = Integer.toString(num % base);
            num /= base;
            container.add(remainder);
        }
        Collections.reverse(container);

        return String.join("", container);
    }

    public int convertToBase10 (int base, int num){
        String nums = String.valueOf(num);
        int divisor = nums.length();
        int [] numsArr = new int[divisor];
        int sum = 0;

        for (int index = 0; index < numsArr.length; index++) {
            numsArr[index] = nums.charAt(index) - '0';
        }

        divisor--;

        for (int index = 0; index < numsArr.length; index++) {
            sum += (numsArr[index]*Math.pow(base, divisor));
            divisor--;
        }

        return sum;
    }
}
