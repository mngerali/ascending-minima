package Assignment;

import java.util.*;

import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.lang3.ArrayUtils;


/**
 * Calculates the below statistics for an array list of double values:
 *  - Minimum Value
 *  - Maximum Value
 *  - Median Value
 *  - Mean Value
 *  - Standard Deviation Value
 *
 */
public class StatisticUtilsArrayList {

    /**
     * The array list of double values
     */
    ArrayList<Double> arrayListValues;

    /**
     * The array of double values
     */
    double[] arrayValues;

    /**
     * Sets the array list of double values and converts it to array of double values.
     */
    public StatisticUtilsArrayList(ArrayList<Double> v) {
        this.arrayListValues = v;
        Double[] arrayValues = this.arrayListValues.toArray(new Double[0]);
        this.arrayValues = ArrayUtils.toPrimitive(arrayValues);
    }

    /**
     * Calculates the minimum value across the array of double values.
     * In case of empty array, Double.NaN is returned.
     */
    public double getMin(){
        return StatUtils.min(this.arrayValues);
    }

    /**
     * Calculates the maximum value across the array of double values.
     * In case of empty array, Double.NaN is returned.
     */
    public double getMax(){
        return StatUtils.max(this.arrayValues);
    }

    /**
     * Calculates the median value across the array of double values.
     * In case of empty array, Double.NaN is returned.
     */
    public double getMedian(){

        return StatUtils.percentile(this.arrayValues, 50);
    }

    /**
     * Calculates the mean value across the array of double values.
     * In case of empty array, Double.NaN is returned.
     */
    public double getMean(){

        return StatUtils.mean(this.arrayValues);
    }

    /**
     * Calculates the standard deviation value across the array of double values.
     * In case of empty array, Double.NaN is returned.
     */
    public double getStd() {
        StandardDeviation sd = new StandardDeviation(false);
        return sd.evaluate(this.arrayValues);
    }
}
