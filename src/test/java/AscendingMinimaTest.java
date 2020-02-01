import Assignment.AscendingMinima;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for the {@link AscendingMinima} class.
 *
 */
public class AscendingMinimaTest {

    /**
     * Generates the necessary inputs for the parameterized test cases.
     * @return a stream of arguments passed at testAscendingMinima function.
     * Each stream entry includes the following:
     * - a set of double values upon which the ascending minima algorithm will be applied
     * - the window size
     * - the expected ascending minima list
     */
    private static Stream<Arguments> provideInputForAscendingMinima() {

        ArrayList<Double> al1 = new ArrayList<Double>();
        List<Double> dl1 = Arrays.asList(6.0,2.0,1.0,5.0,3.0,4.0,8.0,7.0);
        al1.addAll(dl1);

        ArrayList<Double> al2 = new ArrayList<Double>();
        List<Double> dl2 = Arrays.asList(1.0,3.0,3.0,2.0,5.0,8.0,7.0,8.0,9.0,6.0);
        al2.addAll(dl2);

        ArrayList<Double> al3 = new ArrayList<Double>();
        List<Double> dl3 = Arrays.asList(1.0,3.0,3.0,2.0,5.0,8.0,7.0,8.0,9.0,10.0);
        al3.addAll(dl3);

        ArrayList<Double> al4 = new ArrayList<Double>();
        List<Double> dl4 = Arrays.asList(1.0,3.0,3.0,2.0,5.0,8.0,7.0,8.0,9.0,0.0);
        al4.addAll(dl4);

        ArrayList<Double> al5 = new ArrayList<Double>();
        List<Double> dl5 = Arrays.asList(8.0,9.0,5.0,3.0,6.0,5.0,1.0,1.0,0.0);
        al5.addAll(dl5);

        ArrayList<Double> al6 = new ArrayList<Double>();
        List<Double> dl6 = Arrays.asList(7.0,4.0,8.0,6.0,3.0,4.0,2.0,1.0,2.0);
        al6.addAll(dl6);

        ArrayList<Double> al7 = new ArrayList<Double>();
        List<Double> dl7 = Arrays.asList(1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0);
        al7.addAll(dl7);

        ArrayList<Double> al8 = new ArrayList<Double>();
        List<Double> dl8 = Arrays.asList(9.0,8.0,7.0,6.0,5.0,4.0,3.0,2.0,1.0);
        al8.addAll(dl8);

        ArrayList<Double> al9 = new ArrayList<Double>();
        List<Double> dl9 = Arrays.asList(9.0,1.0,1.0,3.0,4.0,2.0,6.0,8.0,9.0);
        al9.addAll(dl9);

        return Stream.of(
                /**
                 * Values: [6.0,2.0,1.0,5.0,3.0,4.0,8.0,7.0]
                 * Window size: 7
                 * Ascending Minima: [1.0,3.0,4.0,7.0]
                 * Use sliding window: Yes
                 * Case: General Example
                */
                Arguments.of(al1, 7, new ArrayList<Double>() {
                    {add(1.0); add(3.0); add(4.0);add(7.0);}
                }),
                /**
                 * Values: [1.0,3.0,3.0,2.0,5.0,8.0,7.0,8.0,9.0,6.0]
                 * Window size: 9
                 * Ascending Minima: [2.0, 5.0, 6.0]
                 * Use sliding window: Yes
                 * Case: Discarded element is the first element of ascending minima
                */
                Arguments.of(al2, 9, new ArrayList<Double>() {
                    {add(2.0); add(5.0); add(6.0);}
                }),
                /**
                 * Values: [1.0,3.0,3.0,2.0,5.0,8.0,7.0,8.0,9.0,10.0]
                 * Window size: 9
                 * Ascending Minima: [2.0, 5.0, 7.0, 8.0, 9.0, 10.0]
                 * Use sliding window: Yes
                 * Case: Incoming element of rolling window is higher than any other value
                 * within ascending minima
                */
                Arguments.of(al3, 9, new ArrayList<Double>() {
                    {add(2.0); add(5.0); add(7.0); add(8.0); add(9.0); add(10.0);}
                }),
                /**
                 * Values: [1.0,3.0,3.0,2.0,5.0,8.0,7.0,8.0,9.0,0.0]
                 * Window size: 9
                 * Ascending Minima: [0.0]
                 * Use sliding window: Yes
                 * Case: Incoming element of rolling window is lower than any other value
                 * within ascending minima
                */
                Arguments.of(al4, 9, new ArrayList<Double>() {
                    {add(0.0);}
                }),
                /**
                 * Values: [8.0,9.0,5.0,3.0,6.0,5.0,1.0,1.0,0.0]
                 * Window size: 9
                 * Ascending Minima: [0.0]
                 * Use sliding window: No
                 * Case: Minimum element as the last element
                */
                Arguments.of(al5, 9, new ArrayList<Double>() {
                    {add(0.0);}
                }),
                /**
                 * Values: [7.0,4.0,8.0,6.0,3.0,4.0,2.0,1.0,2.0]
                 * Window size: 9
                 * Ascending Minima: [1.0, 2.0]
                 * Use sliding window: No
                 * Case: Another general example
                */
                Arguments.of(al6, 9, new ArrayList<Double>() {
                    {add(1.0); add(2.0);}
                }),
                /**
                 * Values: [1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0]
                 * Window size: 9
                 * Ascending Minima: [1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0]
                 * Use sliding window: No
                 * Case: Elements provided in an ascending order.
                */
                Arguments.of(al7, 9, new ArrayList<Double>() {
                    {add(1.0); add(2.0); add(3.0); add(4.0); add(5.0); add(6.0); add(7.0); add(8.0); add(9.0);}
                }),
                /**
                 * Values: [9.0,8.0,7.0,6.0,5.0,4.0,3.0,2.0,1.0]
                 * Window size: 9
                 * Ascending Minima: [1.0]
                 * Use sliding window: No
                 * Case: Elements provided in a descending order.
                */
                Arguments.of(al8, 9, new ArrayList<Double>() {
                    {add(1.0);}
                }),
                /**
                 * Values: [9.0,1.0,1.0,3.0,4.0,2.0,6.0,8.0,9.0]
                 * Window size: 9
                 * Ascending Minima: [1.0, 2.0, 6.0, 8.0, 9.0]
                 * Use sliding window: No
                 * Case: Minimum value found in several positions (the last one is considered)
                */
                Arguments.of(al9, 9, new ArrayList<Double>() {
                    {add(1.0); add(2.0); add(6.0); add(8.0); add(9.0);}
                }),
                /**
                 * Values: [9.0,1.0,1.0,3.0,4.0,2.0,6.0,8.0,9.0]
                 * Window size: 10
                 * Ascending Minima: [1.0, 2.0, 6.0, 8.0, 9.0]
                 * Use sliding window: No
                 * Case: Window provided is greater than the number of elements.
                */
                Arguments.of(al9, 10, new ArrayList<Double>() {
                    {add(1.0); add(2.0); add(6.0); add(8.0); add(9.0);}
                }),
                /**
                 * Case: Empty set of values
                 */
                Arguments.of(new ArrayList<Double>(){}, 10, new ArrayList<Double>(){})
        );
    }

    /**
     * Verifies that the produced value of the ascending minima is the expected one.
     * @param input a set of double values upon which the ascending minima algorithm will be applied
     * @param window the window size
     * @param expected the expected ascending minima list
     */
    @ParameterizedTest
    @MethodSource("provideInputForAscendingMinima")
    public void testAscendingMinima(ArrayList<Double> input, int window, ArrayList<Double> expected) {
        AscendingMinima am = new AscendingMinima(input, window);
        assertEquals(expected, am.findAscMinima());
    }
}
