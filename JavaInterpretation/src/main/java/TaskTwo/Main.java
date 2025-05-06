package TaskTwo;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Main {
    static Scanner input = new Scanner(System.in);

    public static Boolean stringDifferenceIsEmpty(String s1){
        Set<String> supp = new HashSet<>(Set.of("[", "]", "(", ")"));
        Set<String> sub = new HashSet<>(Arrays.asList(s1.split("")));
        sub.removeAll(supp);
        return sub.isEmpty();
    }

    public static void main(String[] args) {
        String theSequence = "[((())()(())]]";
        Algorithm.run(theSequence);

        while (true){
            System.out.println();
            System.out.print("Do you want to continue? [y/n] ");
            String command = input.nextLine();
            if (command.equals("y")){
                System.out.print("Enter a sequence: ");
                String sequence = input.nextLine();
                if (stringDifferenceIsEmpty(sequence))
                    Algorithm.run(sequence);
                else
                    System.out.println("Invalid sequence");
            }
            else if (command.equals("n")){
                break;
            }
            else{
                System.out.println("Invalid command");
            }
        }
    }
}
