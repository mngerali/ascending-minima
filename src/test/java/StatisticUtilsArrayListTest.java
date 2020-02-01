import Assignment.StatisticUtilsArrayList;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for the {@link StatisticUtilsArrayList} class.
 *
 */
public class StatisticUtilsArrayListTest {

    /**
     * Generates the necessary inputs for the parameterized test cases of finding minimum value.
     * The examined cases are the following:
     * - Minimum across positive values
     * - Minimum across positive and negative values
     * - Minimum across the same values
     * - Minimum of an empty array
     * @return a stream of arguments passed at testMin function.
     * Each stream entry includes the following:
     * - an array list of double values
     * - the expected minimum value
     */
    private static Stream<Arguments> provideInputForMin() {
        return Stream.of(
                Arguments.of(new ArrayList<Double>() {
                    {add(1.0); add(2.0); add(3.0);add(4.0); add(5.0); add(6.0);}
                    },1.0),
                Arguments.of(new ArrayList<Double>() {
                    {add(1.0); add(-2.0); add(3.0);add(4.0); add(5.0);}
                    },-2.0),
                Arguments.of(new ArrayList<Double>() {
                    {add(2.0); add(2.0); add(2.0);add(2.0);}
                    },2.0),
                Arguments.of(new ArrayList<Double>(){}, Double.NaN)
        );
    }

    /**
     * Generates the necessary inputs for the parameterized test cases of finding maximum value.
     * The examined cases are the following:
     * - Maximum across positive values
     * - Maximum across positive and negative values
     * - Maximum across the same values
     * - Maximum of an empty array
     * @return a stream of arguments passed at testMax function.
     * Each stream entry includes the following:
     * - an array list of double values
     * - the expected maximum value
     */
    private static Stream<Arguments> provideInputForMax() {
        return Stream.of(
                Arguments.of(new ArrayList<Double>() {
                    {add(1.0); add(2.0); add(3.0);add(4.0); add(5.0); add(6.0);}
                    },6.0),
                Arguments.of(new ArrayList<Double>() {
                    {add(1.0); add(-2.0); add(3.0);add(4.0); add(5.0);}
                    },5.0),
                Arguments.of(new ArrayList<Double>() {
                    {add(2.0); add(2.0); add(2.0);add(2.0);}
                    },2.0),
                Arguments.of(new ArrayList<Double>(){}, Double.NaN)
        );
    }

    /**
     * Generates the necessary inputs for the parameterized test cases of finding mean value.
     * The examined cases are the following:
     * - Mean across positive values
     * - Mean across positive and negative values
     * - Mean across the same values
     * - Mean of an empty array
     * @return a stream of arguments passed at testMean function.
     * Each stream entry includes the following:
     * - an array list of double values
     * - the expected mean value
     */
    private static Stream<Arguments> provideInputForMean() {
        return Stream.of(
                Arguments.of(new ArrayList<Double>() {
                    {add(1.0); add(2.0); add(3.0);add(4.0); add(5.0); add(6.0);}
                    },3.5),
                Arguments.of(new ArrayList<Double>() {
                    {add(1.0); add(-2.0); add(3.0);add(4.0); add(5.0);}
                    },2.2),
                Arguments.of(new ArrayList<Double>() {
                    {add(2.0); add(2.0); add(2.0);add(2.0);}
                    },2.0),
                Arguments.of(new ArrayList<Double>(){}, Double.NaN)
        );
    }

    /**
     * Generates the necessary inputs for the parameterized test cases of finding median value.
     * The examined cases are the following:
     * - Median across even number of values
     * - Median across odd number of values
     * - Median across positive and negative values
     * - Median across the same values
     * - Median of an empty array
     * @return a stream of arguments passed at testMedian function.
     * Each stream entry includes the following:
     * - an array list of double values
     * - the expected median value
     */
    private static Stream<Arguments> provideInputForMedian() {
        return Stream.of(
                Arguments.of(new ArrayList<Double>() {
                    {add(1.0); add(2.0); add(3.0);add(4.0); add(5.0); add(6.0);}
                    },3.5),
                Arguments.of(new ArrayList<Double>() {
                    {add(1.0); add(2.0); add(3.0);add(4.0); add(5.0);}
                    },3.0),
                Arguments.of(new ArrayList<Double>() {
                    {add(1.0); add(-2.0); add(-3.0);add(4.0); add(5.0);}
                    },1.0),
                Arguments.of(new ArrayList<Double>() {
                    {add(2.0); add(2.0); add(2.0);add(2.0);}
                    },2.0),
                Arguments.of(new ArrayList<Double>(){}, Double.NaN)
        );
    }

    /**
     * Generates the necessary inputs for the parameterized test cases of finding standard deviation value.
     * The examined cases are the following:
     * - standard deviation across positive numbers
     * - standard deviation across positive and negative numbers
     * - standard deviation across the same values
     * - standard deviation of an empty array
     * @return a stream of arguments passed at testStd function.
     * Each stream entry includes the following:
     * - an array list of double values
     * - the expected standard deviation value
     */
    private static Stream<Arguments> provideInputForStd() {
        return Stream.of(
                Arguments.of(new ArrayList<Double>() {
                    {add(1.0); add(2.0); add(3.0);add(4.0); add(5.0); add(6.0);}
                    },1.707825127659933),
                Arguments.of(new ArrayList<Double>() {
                    {add(-1.0); add(-2.0); add(1.0);add(2.0);}
                    },1.5811388300841898),
                Arguments.of(new ArrayList<Double>() {
                    {add(2.0); add(2.0); add(2.0);add(2.0);}
                    },0),
                Arguments.of(new ArrayList<Double>(){}, Double.NaN)
        );
    }

    /**
     * Verifies that the produced minimum value is the expected one.
     * @param input a set of double values from which the minimum will be retrieved
     * @param expected the expected minimum value
     */
    @ParameterizedTest
    @MethodSource("provideInputForMin")
    public void testMin(ArrayList<Double> input, double expected) {
        StatisticUtilsArrayList stArr = new StatisticUtilsArrayList(input);
        assertEquals(expected, stArr.getMin());
    }

    /**
     * Verifies that the produced maximum value is the expected one.
     * @param input a set of double values from which the maximum will be retrieved
     * @param expected the expected maximum value
     */
    @ParameterizedTest
    @MethodSource("provideInputForMax")
    public void testMax(ArrayList<Double> input, double expected) {
        StatisticUtilsArrayList stArr = new StatisticUtilsArrayList(input);
        assertEquals(expected, stArr.getMax());
    }

    /**
     * Verifies that the produced mean value is the expected one.
     * @param input a set of double values from which the mean will be retrieved
     * @param expected the expected mean value
     */
    @ParameterizedTest
    @MethodSource("provideInputForMean")
    public void testMean(ArrayList<Double> input, double expected) {
        StatisticUtilsArrayList stArr = new StatisticUtilsArrayList(input);
        assertEquals(expected, stArr.getMean());
    }

    /**
     * Verifies that the produced median value is the expected one.
     * @param input a set of double values from which the median will be retrieved
     * @param expected the expected median value
     */
    @ParameterizedTest
    @MethodSource("provideInputForMedian")
    public void testMedian(ArrayList<Double> input, double expected) {
        StatisticUtilsArrayList stArr = new StatisticUtilsArrayList(input);
        assertEquals(expected, stArr.getMedian());
    }

    /**
     * Verifies that the produced standard deviation value is the expected one.
     * @param input a set of double values from which the standard deviation will be retrieved
     * @param expected the expected standard deviation value
     */
    @ParameterizedTest
    @MethodSource("provideInputForStd")
    public void testStd(ArrayList<Double> input, double expected) {
        StatisticUtilsArrayList stArr = new StatisticUtilsArrayList(input);
        assertEquals(expected, stArr.getStd());
    }
}

