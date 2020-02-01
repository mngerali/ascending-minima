package Assignment;

import java.util.*;
import static java.lang.Integer.min;

/**
 * Calculates the Ascending Minima of a given set of values, by implementing the homonymous algorithm.
 * Given a set of numbers, A, and a window, W, the algorithm finds the minimum value across the first W elements
 * of the given set and continues with the rest values of that window coming after that minimum. The process of finding
 * the current minimum across window in scope and adding it to the ascending minima list is repeated in a similar way,
 * until all values of current window have been evaluated. At this point, an initial list of minimum values has been
 * generated.
 * The algorithm then examines next window, which is the previous rolled by one element. The rejected element is
 * compared with the first element of ascending minima and is being removed from the latter in case they are equal.
 * The incoming element is being included in the ascending minima list and is being compared with the remaining values
 * of ascending minima. Any elements of ascending minima that are greater than the newly added one are being removed
 * from the list. This process is repeated until all upcoming elements have been parsed.
 *
 */
public class AscendingMinima {

    /**
     * The calculated Ascending Minima
     */
    private ArrayList<Double> ascMin = new ArrayList<Double>();

    /**
     * The list of given values
     */
    private ArrayList<Double> initWin;

    /**
     * The rolling window. If greater than the size of initWin, algorithm considers full set of values at once.
     */
    private int window;

    /**
     * The constructor sets the list of values and the initial window.
     */
    public AscendingMinima(ArrayList<Double> initWin, int window) {
        this.initWin = initWin;
        this.window = window;
    }

    /**
     * Adds an element to the Ascending Minima list.
     *
     * @param el the element to be added in the Ascending Minima list.
     */
    public void addElement(Double el){
        this.ascMin.add(el);
    }

    /**
     * Returns the minimum value across window in scope.
     *
     * @param win the current window of Double, normally a sub-set of all values.
     * @return the minimum Double value, across current window.
     */
    public Double getMin(ArrayList<Double> win){
        return Collections.min(win);
    }

    /**
     * Finds the initial Ascending Minima, across the first K elements, K being the window size.
     * Initially, finds the minimum among the K values and adds it in the ascending minima list.
     * It continues with the rest values of that set which are coming after that minimum. The process
     * of finding the current minimum across window in scope and adding it to the ascending minima list
     * is repeated in a similar way, until all values of current set have been evaluated.
     *
     * @param curWin the window including the first <window> values.
     * @return the ascending minima of <curWin> window.
     */
    public void findInitAscMinima(ArrayList<Double> curWin) {
        Double minValue;
        ArrayList<Double> sw;

        /**
         * Find minimum value across curWin
         */
        minValue = this.getMin(curWin);
        this.addElement(minValue);

        /**
         * Find the index of the last occurrence of minimum value
         */
        int startIdx = curWin.lastIndexOf(minValue);

        /**
         * Iterate at the rest of the values, finding the current minimum.
         */
        sw = new ArrayList<Double>(curWin.subList(startIdx + 1, curWin.size()));
        while (! sw.isEmpty()) {
            minValue = this.getMin(sw);
            this.addElement(minValue);
            startIdx = curWin.lastIndexOf(minValue);
            sw = new ArrayList<Double>(curWin.subList(startIdx + 1, curWin.size()));
        }
    }

    /**
     * Finds the final Ascending Minima across all elements, considering the initial one.
     * The algorithm examines next window, by rolling the initial by one element. The rejected  due to the rolling
     * element is compared with the first element of ascending minima and is being removed from the latter, in case they
     * are equal. The incoming element is being included in the ascending minima list and is being compared with the
     * remaining values of ascending minima. Any elements of ascending minima that are greater than the newly added one
     * are being removed from the list. This process is repeated until all upcoming elements have been parsed.
     *
     * @param newEl the new element which was included in the current rolling window.
     * @param discEl the element that was discarded due to the moving of the rolling window.
     */
    public void updateAscMinima(Double newEl, Double discEl){
        if (ascMin.get(0) == discEl) {
            ascMin.remove(0);
        }
        ascMin.removeIf(n -> (n > newEl));
        this.addElement(newEl);
    }

    /**
     * Wrapper function that calculates Ascending Minima, by utilizing functions findInitAscMinima and updateAscMinima.
     * The process stops when all elements have been parsed. In case of an empty set, an empty set is returned as well.
     */
    public ArrayList<Double> findAscMinima() {
        if (this.initWin.isEmpty()){
            return this.ascMin;
        }
        ArrayList<Double> window;
        int length = this.initWin.size();
        int startPoint = 0;
        Double newEl, discEl;
        int endPoint = min(startPoint + this.window, length);
        window = new ArrayList<Double>(this.initWin.subList(startPoint, endPoint));
        findInitAscMinima(window);

        while (endPoint < length) {
            newEl = this.initWin.get(endPoint);
            discEl = this.initWin.get(startPoint);
            updateAscMinima(newEl, discEl);
            startPoint += 1;
            endPoint += 1;
        }
        return this.ascMin;
    }
}

