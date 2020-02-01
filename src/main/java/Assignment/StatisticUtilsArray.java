package Assignment;

import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

/**
 * Calculates the below statistics for an array of double values:
 *  - Minimum Value
 *  - Maximum Value
 *  - Median Value
 *  - Mean Value
 *  - Standard Deviation Value
 *
 */
public class StatisticUtilsArray {

    /**
     * The array of double values
     */
    double[] values;

    /**
     * Sets the array of double values
     */
    public StatisticUtilsArray(double[] v) {
        this.values = v;
    }

    /**
     * Calculates the minimum value across the array of double values.
     * In case of empty array, Double.NaN is returned.
     */
    public double getMin(){

        return StatUtils.min(this.values);
    }

    /**
     * Calculates the maximum value across the array of double values.
     * In case of empty array, Double.NaN is returned.
     */
    public double getMax(){

        return StatUtils.max(this.values);
    }

    /**
     * Calculates the median value across the array of double values.
     * In case of empty array, Double.NaN is returned.
     */
    public double getMedian(){

        return StatUtils.percentile(this.values, 50);
    }

    /**
     * Calculates the mean value across the array of double values.
     * In case of empty array, Double.NaN is returned.
     */
    public double getMean(){

        return StatUtils.mean(this.values);
    }

    /**
     * Calculates the standard deviation value across the array of double values.
     * In case of empty array, Double.NaN is returned.
     */
    public double getStd() {
        StandardDeviation sd = new StandardDeviation(false);
        return sd.evaluate(this.values);
    }
}