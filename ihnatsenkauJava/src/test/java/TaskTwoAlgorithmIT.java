import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;


public class TaskTwoAlgorithmIT {

    @ParameterizedTest
    @MethodSource
    void isBracesSequenceCorrect(String input, Boolean expected_result){
        assertEquals(expected_result, TaskTwo.Algorithm.isBracesSequenceCorrect(input));
    }

    static Stream<Arguments> isBracesSequenceCorrect(){
        return Stream.of(
                Arguments.of("", true),
                Arguments.of("[]", true),
                Arguments.of("[]()", true),
                Arguments.of("[()]", true),
                Arguments.of("([()])", true),
                Arguments.of("(", false),
                Arguments.of(")", false),
                Arguments.of("[(]", false),
                Arguments.of("[)]", false),
                Arguments.of("([)", false),
                Arguments.of("(])", false),
                Arguments.of("[[(]]", false),
                Arguments.of("[([)]]", false)
        );
    }

    @ParameterizedTest
    @MethodSource
    void getInvalidBraceIndices(String input, List<Integer> expected_result){
        assertEquals(expected_result, TaskTwo.Algorithm.getInvalidBraceIndices(input));
    }

    static Stream<Arguments> getInvalidBraceIndices(){
        return Stream.of(
                Arguments.of("", List.of()),
                Arguments.of(")", List.of(1)),
                Arguments.of("]", List.of(1)),
                Arguments.of("[", List.of(1)),
                Arguments.of("(", List.of(1)),
                Arguments.of("[()]]", List.of(5)),
                Arguments.of(")[()]]", List.of(1, 6)),
                Arguments.of("[()][[[[[", List.of(5, 6, 7, 8, 9)),
                Arguments.of("[(])", List.of(1, 2, 3, 4))
        );
    }
}
