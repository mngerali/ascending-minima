This project includes the below classes:
- Class `StatisticUtilsArray`: provides a set of statistical values (min,
max, median, mean and std) on an array of doubles.
- Class `StatisticUtilsArrayTest`: performs testing of the functions implemented
within StatisticUtilsArray class
- Class `StatisticUtilsArrayList`: provides a set of statistical values (min,
max, median, mean and std) on an array list of doubles
- Class `StatisticUtilsArrayListTest`: performs testing of the functions
implemented within StatisticUtilsArrayList class
- Class `AscendingMinima`: implements the Ascending Minima algorithm.
Given a set of numbers, A, and a window, W, the algorithm finds the minimum
value across the first W elements of the given set and continues with the rest
values of that window coming after that minimum. The process of finding the
current minimum across window in scope and adding it to the ascending minima
list is repeated in a similar way, until all values of current window have been
evaluated. At this point, an initial list of minimum values has been
generated.
The algorithm then examines next window, which is the previous rolled by one
element. The rejected element is compared with the first element of ascending
minima and is being removed from the latter in case they are equal. The incoming
element is being included in the ascending minima list and is being compared
with the remaining values of ascending minima. Any elements of ascending minima
that are greater than the newly added one are being removed from the list.
This process is repeated until all upcoming elements have been parsed.
- Class `AscendingMinimaTest`: performs testing of the aforementioned Algorithm.
- Class `MainClass`: Wrapper class that creates object of each class and prints
the produced results.
