package pollenStats;

import java.util.TreeMap;

public class AnalysisOfVariance {

    public static TreeMap<String, Double> anovaMap(Double[][] nestedArrays) {

        // Map and sum of squares values, initially initialized to zero.
        TreeMap analysisMap = new TreeMap<String, Integer>();

        // Sum of squares of each data point minus the mean calculated by ((total sum of each array mean) / total array number).
        double sumOfSquaresTotal = 0.0;
        // Sum of squares of each data point minus the mean of the respective array containing that data point
        double sumOfSquaresWithin = 0.0;
        // Sum of degrees of freedom for the sum of squares within (total sum of (array length - 1) * number of arrays)
        int withinDegreesFreedom = 0; // m * (n-1) d.f.
        // Sum of squares of (array.length) * (array mean - mean of means)
        double sumOfSquaresBetween = 0.0;
        int betweenDegreesFreedom = nestedArrays.length - 1; // m-1 d.f.

        // Used to calculate the mean of means
        double meanOfMeans = 0.0;
        int count = 0;

        // Calculates the mean of all datapoints.
        for(int i = 0; i < nestedArrays.length; i++){
            // Retrieving the mean for each list to work out the sum of
            for(int j = 0; j < nestedArrays[i].length; j++) {
                meanOfMeans += nestedArrays[i][j];
                count ++;
            }
        }
        meanOfMeans = meanOfMeans / count;

        // Calculates the sum of square; total (point mins mean of means), within (point minus containing array mean) and between (array.length * (array mean - mean of means) )
        for(int i = 0; i < nestedArrays.length; i++){
            double tempArrayMean = BaseFunctions.mean(nestedArrays[i], "i");
            for (int j = 0; j < nestedArrays[i].length; j++) {
                double individualSquare = Math.pow(nestedArrays[i][j] - meanOfMeans, 2);
                sumOfSquaresTotal += individualSquare;
                double withinSquare = Math.pow(nestedArrays[i][j] - tempArrayMean, 2);
                sumOfSquaresWithin += withinSquare;
            }
            sumOfSquaresBetween += nestedArrays[i].length * Math.pow((tempArrayMean - meanOfMeans), 2);
            withinDegreesFreedom += nestedArrays[i].length -1;
        }

        // Placing the SST in the analysis map with the total degrees of freem.
        analysisMap.put("SST", sumOfSquaresTotal);
        analysisMap.put("SST Degrees Freedom", count - 1);
        analysisMap.put("SSW", sumOfSquaresWithin);
        analysisMap.put("SSW Degrees Freedom", withinDegreesFreedom);
        analysisMap.put("SSB", sumOfSquaresBetween);
        analysisMap.put("SSB Degrees Freedom", betweenDegreesFreedom);
        analysisMap.put("F Statistic", ((sumOfSquaresBetween / betweenDegreesFreedom) / (sumOfSquaresWithin / withinDegreesFreedom)));

        return analysisMap;
    }

}

