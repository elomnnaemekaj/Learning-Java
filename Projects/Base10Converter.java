import java.util.ArrayList;
import java.util.Collections;

public class Base10Converter {
    public static void main(String[] args) {
        Converter converter = new Converter();
        System.out.println(converter.convertFromBase10(5,309));
        System.out.println(converter.convertToBase10(2,1111));
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
