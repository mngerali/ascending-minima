package Assignment;

import java.util.*;

/**
 * Contains the main class of the application.
 *
 */
public class MainClass {
    public static void main(String[] args) {

        double[] numbers = {1, 2, 3, 4, 5, 6};
        StatisticUtilsArray stArr = new StatisticUtilsArray(numbers);
        System.out.println("Array Stats:");
        System.out.println("Min value: " + stArr.getMin());
        System.out.println("Max value: " + stArr.getMax());
        System.out.println("Median value: " + stArr.getMedian());
        System.out.println("Mean value: " + stArr.getMean());
        System.out.println("Std value: " + stArr.getStd());


        ArrayList<Double> values = new ArrayList<Double>() {
            {add(1.0); add(2.0); add(3.0);add(4.0); add(5.0); add(6.0);}
        };

        StatisticUtilsArrayList stArrL = new StatisticUtilsArrayList(values);
        System.out.println("ArrayList Stats:");
        System.out.println("Min value: " + stArrL.getMin());
        System.out.println("Max value: " + stArrL.getMax());
        System.out.println("Median value: " + stArrL.getMedian());
        System.out.println("Mean value: " + stArrL.getMean());
        System.out.println("Std value: " + stArrL.getStd());


        System.out.println("Ascending Minima algorithm");
        ArrayList<Double> al = new ArrayList<Double>();
        List<Double> doubleList = Arrays.asList(1.0,3.0,3.0,2.0,5.0,8.0,7.0,8.0,9.0,0.0);
        al.addAll(doubleList);
        AscendingMinima asm = new AscendingMinima(al, 9);
        ArrayList<Double> minima = asm.findAscMinima();
    }
}