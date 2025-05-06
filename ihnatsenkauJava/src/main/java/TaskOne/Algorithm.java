package TaskOne;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Algorithm {
    private static final Pattern arrayPattern = Pattern.compile(
            "^\\[\\s*-?\\d+(\\.\\d+)?(\\s*,\\s*-?\\d+(\\.\\d+)?)*\\s*\\]$");

    private static final Pattern numberPattern = Pattern.compile("-?\\d+(?:\\.\\d+)?");

    public static boolean isNumArray(String inputData) {
        Matcher matcher = arrayPattern.matcher(inputData);
        return matcher.matches();
    }

    public static List<Double> findAllMultiplesOf3(String input) {
        Matcher matcher = numberPattern.matcher(input);
        List<Double> result = new ArrayList<>();

        while (matcher.find()) {
            double number = Double.parseDouble(matcher.group());
            if (number % 3 == 0){
                result.add(number);
            }
        }
        return result;
    }

    public static Boolean isGreaterThan7(String input){
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return Double.parseDouble(input) > 7;
    }



}