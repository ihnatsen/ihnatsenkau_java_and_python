import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;


public class TaskOneAlgorithmIT {
    @ParameterizedTest
    @MethodSource
    void isNumArrayValid(String input_data) {
         assertTrue(TaskOne.Algorithm.isNumArray(input_data));
    }

    @ParameterizedTest
    @MethodSource
    void isNumArrayInValid(String input_data) {
        assertFalse(TaskOne.Algorithm.isNumArray(input_data));
    }

    @ParameterizedTest
    @MethodSource
    void testFindAllMultiplesOf3(String input_data, List<Double> expected_result){
        assertEquals(expected_result, TaskOne.Algorithm.findAllMultiplesOf3(input_data));
    }

    @ParameterizedTest
    @MethodSource
    void testIsGreaterThan7(String input_data, Boolean expected_result){
        assertEquals(expected_result, TaskOne.Algorithm.isGreaterThan7(input_data));
    }

    static Stream<Arguments> testIsGreaterThan7(){
        return Stream.of(
                Arguments.of("-5", false),
                Arguments.of("-5.0", false),
                Arguments.of("0", false),
                Arguments.of("0.0", false),
                Arguments.of("7", false),
                Arguments.of("7.0", false),
                Arguments.of("10", true),
                Arguments.of("10.0", true),
                Arguments.of("NOT DOUBLE", false)
        );
    }


    static Stream<Arguments> testFindAllMultiplesOf3(){
        return Stream.of(
                Arguments.of("[3]", List.of(3.0)),
                Arguments.of("[3, 6]", List.of(3.0, 6.0)),
                Arguments.of("[3, 6, 9]", List.of(3.0, 6.0, 9.0)),
                Arguments.of("[3.0, 4, 14, 15]" , List.of(3.0, 15.0))
        );
    }


    static Stream<String> isNumArrayInValid(){
        return Stream.of(
                "[]",
                "[][]",
                "[not is digit]",
                "[not is digit, 4]"
        );
    }

    static Stream<String> isNumArrayValid(){
        return Stream.of(
                "[1, 2, 3, 4]",
                "[0, 1, 2, 3, 4]",
                "[0, -1, 2, -3, -4]",
                "[0.0, -1.0, 2, -3.0, -4.1]",
                "[3.0, 2]"
        );
    }
}
