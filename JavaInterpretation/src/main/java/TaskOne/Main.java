package TaskOne;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Please enter data for the program.");
        System.out.println("To input an array, use the format: [<value1>, <value2>, ...]");
        System.out.println("For example: [1, 2, 3]\n");
        System.out.print("Input data: ");

        String data = input.nextLine();
        if (data.equals("John")){
            System.out.println("Hello John");
        } else if (Algorithm.isGreaterThan7(data)) {
            System.out.println("Hello");
        } else if (Algorithm.isNumArray(data)) {
            System.out.println("The array contains multiples of 3: ");
            System.out.println(Algorithm.findAllMultiplesOf3(data));
        }
    }
}
