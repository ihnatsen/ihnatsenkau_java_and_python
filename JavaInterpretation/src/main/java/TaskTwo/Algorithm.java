package TaskTwo;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Algorithm {
    public static Boolean isBracesSequenceCorrect(String input){
        Map<Character, Character> braces = Map.of(
                ')', '(',
                ']', '['
                );
        Stack<Character> stack = new Stack<>();
        for (char brace : input.toCharArray()) {
            if ("[(".contains(String.valueOf(brace))){
                stack.push(brace);
            } else if (stack.empty()) {
                return false;
            } else if (!braces.get(brace).equals(stack.pop())) {
                return false;
            }
        }
        return stack.empty();
    }

    public static List<Integer> getInvalidBraceIndices(String data){
        List<Character> sequence = data.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        Map<Character, Character> braces = Map.of(')', '(', ']', '[');
        Stack<Item> stack = new Stack<>();
        Set<Integer> toRemove = new HashSet<>();


        for (int i = 0; i < sequence.size(); i++) {
            if ("[(".contains(String.valueOf(sequence.get(i)))){
                stack.push(new Item(i, sequence.get(i)));
            } else if (")]".contains(String.valueOf(sequence.get(i)))) {
                if (stack.empty()){toRemove.add(i);}
                else{
                    Item openItem = stack.pop();
                    if(!braces.get(sequence.get(i)).equals(openItem.brace())){
                        toRemove.add(openItem.index());
                        toRemove.add(i);
                    }
                }
            }
        }
        while (!stack.empty()){
            Item openItem = stack.pop();
            toRemove.add(openItem.index());
        }
        return toRemove.stream().map(i -> i + 1).sorted().collect(Collectors.toList());
    }

    public static void run(String sequence) {
        Boolean isOK = isBracesSequenceCorrect(sequence);
        System.out.printf("The sequence: %s\n", sequence);
        System.out.printf("can%s ", isOK ? " " : "not");
        System.out.println("considered correct.");
        if (!isOK)
            System.out.printf("Need to delete brace: %s", getInvalidBraceIndices(sequence));
    }

}
class Item {
    Integer index;
    Character brace;

    Item(Integer index, Character brace) {
        this.index = index;
        this.brace = brace;
    }

    Integer index() {
        return index;
    }

    Character brace() {
        return brace;
    }
}