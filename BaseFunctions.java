package pollenStats;

import java.util.*;
import java.util.stream.*;
import java.util.Random;

import static pollenStats.PearsonCoefficent.dataMap;

public class BaseFunctions {

    public static double mean(Double[] targetArray, String arrayName){

        double total = 0;
        double count = 0;
        for(int i =0; i < targetArray.length; i++){
            total += targetArray[i];
            count += 1;
        }
        double theMean = total / count;
        //System.out.println("The mean value of " + arrayName + " is: " + theMean);

    return theMean;
    }

    public static double actualMedian(Double[] targetArray, String arrayName){

        int arraySize = targetArray.length;
        double actual = 0;
        if ((arraySize % 2) == 1){
            // Reduces total length by one to be even, then halves, giving the index of the median as indexing starts at 0
            // e.g. 17 becomes sixteen, which becomes 8, which gives the median (9).
            int index = ((arraySize -1)/2);
            actual += targetArray[index];
        }
        else{
            // Gives first position, e.g in an array of sixteen, gives seven, which is the element in position 8.
            int indexOne = (arraySize/2) -1;
            // Element in position nine
            int indexTwo = (arraySize/2);
            // The average
            actual += (targetArray[indexOne] + targetArray[indexTwo])/2;
        }
        System.out.println("The " + arrayName + " median is: " + actual);
    return actual;
    }

    public static double[] percentiles (Double[] dataPoints, String arrayName){

        //Map to be returned by function so that data points are accessible once the split is complete
        double[] interQuartileRanges = new double[2];
        int arraySize = dataPoints.length;
        ArrayList <Double> partOne = new ArrayList <Double>();
        ArrayList <Double> partTwo = new ArrayList <Double>();
        double medOne = 0.0;
        double medTwo = 0.0;
        if ((arraySize % 2) == 1){
            // Consider array of 7 elements. Starts from left and stops at index 3, the fourth element.
            for(int i = 0; i < ((arraySize/2) - 0.5); i++){
                partOne.add(dataPoints[i]);
            }
            // Array of seven; Starts at the fifth element, the first element after the median.
            for(int i = (int) ((arraySize/2) + 1); i < arraySize; i++){
                partTwo.add(dataPoints[i]);
            }
            medOne += ((partOne.get((int) ((partOne.size()/2) - 1)) + partOne.get((int) ((partOne.size()/2))))/2);
            medTwo += ((partTwo.get((int) ((partTwo.size()/2) -1)) + partTwo.get((int) ((partTwo.size()/2))))/2);
            interQuartileRanges[0] = medOne;
            interQuartileRanges[1] = medTwo;
        }
        else{
            // Consider array of 6 elements. Starts from the left and continues upto but not including index 3, the fourth element.
            for(int i = 0; i < (arraySize/2); i++){
                partOne.add(dataPoints[i]);
                // Half of the array, minus half a point, gives the index of the Median point, given that an even number is the sum of two odd numbers.
            }
            // Array of seven; Starts at position four and continues up until the end.
            for(int i = (arraySize/2); i < arraySize; i++){
                partTwo.add(dataPoints[i]);
            }
            medOne += partOne.get(((partOne.size()/2)));
            medTwo += partTwo.get(((partTwo.size()/2)));
            interQuartileRanges[0] = medOne;
            interQuartileRanges[1] = medTwo;
        }
        System.out.println("The lower quartile range for " + arrayName + " is: " + interQuartileRanges[0]);
        System.out.println("The upper quartile range is: " + arrayName + " is: " + interQuartileRanges[1]);
        return interQuartileRanges;
    }

    public static double standardDeviation(Double[] results) {

            // Defining integer variables based on the array length and array length minus one to calculate the standard deviation
            float array_size = results.length;
            float array_minus_one = array_size - 1;
            float sum_individuals_squared = 0;
            float series_sum = 0;
            // Calls to System.out with println to print the array and the size of the array. Uses newLine from System.getProperty for line separation.
            String newLine = System.getProperty("line.separator");
            //System.out.println("Printing array... " + Arrays.toString(results));
            //System.out.println("Size of array is " + array_size + " elements" + newLine);
            //for( int i = 0; i < results.length - 1; i++) #Alternative loop syntax
            int i = 0;
            //Loop to sum the square of each number in the series. Assigns to the variable sum_individuals_squared
            while (i < array_size){
                double square = results[i] * results[i];
                sum_individuals_squared += square;
                ++i;
                //System.out.println("Element square is: " + square);
            }
            //System.out.println(newLine);
            //System.out.println("The sum(each element of the array * itself) is: " + sum_individuals_squared);
            int j = 0;
            // Loop to sum the square of the sum of the series. Assigns to the variable series_sum_squared
            while (j < array_size){
                series_sum += results[j];
                ++j;
            }
            float series_sum_squared = series_sum * series_sum;
            //System.out.println("The square of sum(each element of the array) is: " + series_sum_squared);
            // Using the formula provided in MA108 lecture, plugging in the variables calculated earlier:
            float variance = (sum_individuals_squared - (series_sum_squared / array_size)) / array_minus_one;
            // Final calls to System.out.println to print the Variance and SD.
            //System.out.println("The Variance of the array is : " + variance);
            //System.out.println("The Standard Deviation of the array is : " + Math.sqrt(variance));
            return Math.sqrt(variance);
        }

        public static int[] arrayGenerator() {

            int[] a = new int[15];

            for (int i = 1; i <= 15; i++)
            {
                a[i-1] = i;
            }

            Random rg = new Random();
            int tmp;
            for (int i = 14; i > 0; i--)
            {
                int r = rg.nextInt(i+1);
                tmp = a[r];
                a[r] = a[i];
                a[i] = tmp;
            }

            return a;
        }

        public static double linearRegressionCorrelationCoefficent(double[] x, double[] y) {


            //Using java.util.stream.StreamInt to sum the arrays
            double xSum = DoubleStream.of(x).sum();
            double ySum = DoubleStream.of(y).sum();
            // Sum of element squares
            double count = 0;
            for (int i = 0; i > x.length ; i++){
                double current_square = x[i] * x[i];
                count = count + current_square;
            }
            // Iterate through both arrays. Create product for iterations. Sum products. Square.
            for (int i = 0; i > 10 ; i++){

            }
            double sXX = - (xSum * xSum) / x.length;
            double sYY = - (ySum * ySum) / x.length;
            double sXY = - (xSum * ySum) / x.length;
            double correlation = sXY / Math.sqrt((sXX*sYY));
            return correlation;
        }

        public static double sumArraySquared(String array){

            // Initialize the square of the array to zero
            double sumOfArraySquared = 0.0;
            double[] theArray = Stream.of(dataMap.get(array)).mapToDouble(Double::doubleValue).toArray();
            Stream.of(dataMap.get(array)).mapToDouble(Double::doubleValue).toArray();

            // Iterate through loop, updating the array sum with the square of each element
            for (int i = 0; i < theArray.length; i++){
                sumOfArraySquared += theArray[i] * theArray[i];
            }

        return sumOfArraySquared;
        }

        public static double sumXTimesY(String arrayOne, String arrayTwo){

            // Initializing sum to iteratively update and converting the Double array in the main dataMap to primitive type
            double totalSum = 0.0;
            double[] x = Stream.of(dataMap.get(arrayOne)).mapToDouble(Double::doubleValue).toArray();
            double[] y = Stream.of(dataMap.get(arrayTwo)).mapToDouble(Double::doubleValue).toArray();

            for(int i = 0; i < x.length; i++){
                totalSum += (x[i] * y[i]);
            }

        return totalSum;
        }

}
