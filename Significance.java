/**
 * Created by Luke Pollen of pollenanalytics.com on 05/07/2017.
 */

package pollenStats;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Significance {

    public static double standardErrorOfMean(double standardDeviation, int sampleSize){

        double standardErrorOfMean = standardDeviation / Math.sqrt(sampleSize);

    return standardErrorOfMean;
    }

    // Returns a t-statistic related to two samples which can be usd to provide confidence as to whether their means are equal.
    public static double twoSampleTTestStatistic(Double[] sampleOne, Double[] sampleTwo){

        // Get the mean for the samples.
        double xOne = BaseFunctions.mean(sampleOne, "Sample One");
        double xTwo = BaseFunctions.mean(sampleTwo, "Sample Two");

        // Get the numerator by calculating the difference between the means.
        double meanDifference = xOne - xTwo;

        // Get the reciprocals of the sample size for each sample.
        int firstSampleSizeReciprocal = 1 / sampleOne.length;
        int secondSampleSizeReciprocal = 1 / sampleTwo.length;

        // Get the degrees of freedom for the samples.
        int firstSampleDegreesFreedom = sampleOne.length - 1;
        int secondSampleDegreesFreedom = sampleTwo.length - 1;

        // Get the variance of the samples.
        double firstSampleVariance = BaseFunctions.standardDeviation(sampleOne) * BaseFunctions.standardDeviation(sampleOne);
        double secondSampleVariance = BaseFunctions.standardDeviation(sampleTwo) * BaseFunctions.standardDeviation(sampleTwo);
        double pooledVariance = (firstSampleDegreesFreedom * firstSampleVariance) + (secondSampleDegreesFreedom * secondSampleVariance) / (sampleOne.length + sampleTwo.length  - 2);

        // Calculate the full denominator.
        // As sample sizes increase, the t statistic will get bigger if meanDifference remains the same
        double denominator = Math.sqrt(pooledVariance * (firstSampleSizeReciprocal + secondSampleSizeReciprocal));
        double tStatistic = meanDifference / denominator;

    return tStatistic;
    }

    public static ArrayList<Double> twoSamplesTTestConfidenceInterval(Double[] sampleOne, Double[] sampleTwo, double confidenceLevel) {

        ArrayList<Double> theBounds = new ArrayList<Double>();

        // Return t statistics for the confidence level.
        double tStatistic = lookup(confidenceLevel);

        // Get the mean for the samples.
        double xOne = BaseFunctions.mean(sampleOne, "Sample One");
        double xTwo = BaseFunctions.mean(sampleTwo, "Sample Two");

        // Get the degrees of freedom for the samples.
        int firstSampleDegreesFreedom = sampleOne.length - 1;
        int secondSampleDegreesFreedom = sampleTwo.length - 1;

        // Get the variance of the samples.
        double firstSampleVariance = BaseFunctions.standardDeviation(sampleOne) * BaseFunctions.standardDeviation(sampleOne);
        double secondSampleVariance = BaseFunctions.standardDeviation(sampleTwo) * BaseFunctions.standardDeviation(sampleTwo);

        double pooledVariance = (firstSampleDegreesFreedom * firstSampleVariance) + (secondSampleDegreesFreedom * secondSampleVariance) / (sampleOne.length + sampleTwo.length  - 2);

        // Get the reciprocals of the sample size for each sample.
        int firstSampleSizeReciprocal = 1 / sampleOne.length;
        int secondSampleSizeReciprocal = 1 / sampleTwo.length;

        // Get the numerator by calculating the difference between the means.
        double meanDifference = xOne - xTwo;

        // Determine the modifiers to the difference of means which can be used to calculate the lower and upper bounds.
        double modifier = tStatistic * Math.sqrt(pooledVariance * (firstSampleSizeReciprocal + secondSampleSizeReciprocal));

        double lowerBound = meanDifference - modifier;
        double upperBound = meanDifference + modifier;

        theBounds.add(lowerBound);
        theBounds.add(upperBound);

        return theBounds;
    }

    // Used when not performing under the null hypothesis that the difference in means is zero.
    public static double twoSampleTTest(ArrayList<Double> sampleOne, ArrayList<Double> sampleTwo, double sampleMeanOne, double sampleMeanTwo){

        double tStatistic = 0.0;

        // Method body

        // Return the t statistic.
        return tStatistic;
    }

    // Returns an arrayList of doubles for the lower bound, proportion of successes in the sample and the upperbound.
    public static ArrayList<Double> populationProportion(double confidencePercent, double trials, double successes, boolean printFlag){

        //Double list to return the lower bound, pHat and upperBound.
        ArrayList<Double> confidenceIntervalValues = new ArrayList<>();
        // DecimalFormat object to enable printing to 4 places of accuracy within System.out.println();
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(4);

        // Currently uses a passed value for the cofidence interval coefficent. Update this method to return a coefficent returned from a table.
        double pHat = ( successes / trials);
        System.out.println(pHat);
        double qHat = ( 1 - pHat );
        System.out.println(qHat);
        double e = confidencePercent * Math.sqrt(((pHat)*(qHat))/trials);
        System.out.println(e);

        // Calculate population proportion values and update the arrayList to be returned.
        confidenceIntervalValues.add(pHat - e);
        confidenceIntervalValues.add(pHat);
        confidenceIntervalValues.add(pHat + e);

        // Print the confidence interval if a true printFlag was supplied.
        if (printFlag) {
            System.out.println("The Confidence interval is : " + df.format(confidenceIntervalValues.get(0)) + ", " + df.format(confidenceIntervalValues.get(2)));
        }

    return confidenceIntervalValues;
    }

    public static HashMap<String, Double> singleTTest(double sampleMean, double hypothesizedMean, double sampleStandardDeviation, int sampleSize, boolean printFlag){

        /*
        You have a randomly selected sample.
        The sample is significantly smaller than the population.
        If the sample size is under 15, t tests are only safe if the data shows no strong departures from the Normal distribution.
        If the sample size is over 15, t tests are only safe if there are no outliers and there is no strong skewness.
        If the sample size is over 40, t tests tend to be safe even if the data is strongly skewed.
        These conditions are just rules of thumb and don’t necessarily apply everywhere.
        */

        double tStatistic = (sampleMean - hypothesizedMean) / (sampleStandardDeviation / Math.sqrt(sampleSize));
        HashMap tValues = new HashMap<String, Double>();
        tValues.put("tStatistic", tStatistic);
        tValues.put("Degrees of Freedom", sampleSize - 1);

        if(printFlag){
            System.out.println("The tStatistic is: " + tStatistic);
        }

    return tValues;
    }

    public static HashMap<String, Double> pairedTTest(double meanOne, double meanTwo){

        HashMap tValues = new HashMap<String, Double>();


    return tValues;
    }

    public static HashMap<String, Double> differenceTwoSampleMeans(Double[] sampleSetOne, Double[] sampleSetTwo, double confidencePercentage, boolean printFlag){

        // Retrieves the tStatistic value associated with the combined degrees of freedom of each sample size - 2
        List<HashMap<Double, List<Double>>> tValues = StatisticsData.tValueLookup();
        HashMap firstMap = tValues.get(0);
        List<Double> theFirst = (List<Double>) firstMap.get(confidencePercentage);
        // Uses sample size one plus sample size two minus two for the degrees of freedom, but substracts another one because of zero indexing in the array.
        Double theValue = theFirst.get(sampleSetOne.length + sampleSetTwo.length - 2 - 1);

        int sampleSizeOne = sampleSetOne.length;
        int sampleSizeTwo = sampleSetTwo.length;

        double meanDifference = Math.abs(BaseFunctions.mean(sampleSetOne, "Sample One") - BaseFunctions.mean(sampleSetTwo, "Sample Two"));
        double sampleOneSD = BaseFunctions.standardDeviation(sampleSetOne);
        double sampleTwoSD = BaseFunctions.standardDeviation(sampleSetTwo);
        double pooledVariance = (((sampleSizeOne - 1) * (sampleOneSD * sampleOneSD)) + ((sampleSizeTwo - 1) * (sampleTwoSD * sampleTwoSD))) / (sampleSizeOne + sampleSizeTwo - 2);
        double standardErrorDifferenceMeans = Math.sqrt((pooledVariance/sampleSizeOne)+(pooledVariance/sampleSizeTwo));
        double tStatistic = meanDifference / standardErrorDifferenceMeans;

        if(printFlag){
            System.out.println("The tStatistic is: " + tStatistic);
        }

        double lowerBound = meanDifference - (theValue * standardErrorDifferenceMeans);
        double upperBound = meanDifference + (theValue * standardErrorDifferenceMeans);
        HashMap dataItems = new HashMap<String, Double>();
        dataItems.put("tStatistics", tStatistic);
        dataItems.put("Lower Bound", lowerBound);
        dataItems.put("Upper Bound", upperBound);

    return dataItems;
    }

    public static double zSignificanceTest(double populationMean, double hypothesizedMean, double populationStandardDeviation, double sampleMean, int sampleSize, boolean printFlag){

        /*
        To test whether your sample average is statistically consistent with a hypothesized population average.
        You have a randomly selected sample.
        The sample is significantly smaller that the population.
        The variable in question has a perfectly Normal distribution.
        We “know” the population standard deviation. ***Unrealistic under most circumstances.***
        */

        double zStatistic = (sampleMean - hypothesizedMean) / (populationStandardDeviation / Math.sqrt(sampleSize));
        if (printFlag){
            System.out.println("Null Hypothesis: the population mean is " + populationMean);
            System.out.println("Alternative Hypothesis: the population mean is not " + populationMean);
            System.out.println("The zStatistic is: " + zStatistic);
        }


    return zStatistic;
    }

    public static HashMap<String, Double> tConfidenceInterval(double sampleMean, double standardDeviation, int sampleSize, double confidence, boolean printFlag){

        // Retrieving the table of critical t-values as a list of HashMaps
        List<HashMap<Double, List<Double>>> tableTest = StatisticsData.tValueLookup();
        HashMap firstMap = tableTest.get(0);

        // Retrieving the list of critical t-values for a 95% two tail confidence interval (equal to a 97.5% one tail confidence interval)
        DecimalFormat temporary = new DecimalFormat("##.00");
        double alpha = Double.parseDouble(temporary.format(1.00 - confidence));
        List<Double> theFirst = (List<Double>) firstMap.get(alpha);
        // Accessing the list by the index of the degrees of freedom
        Double theValue = theFirst.get(sampleSize - 2);

        // Calculating standardError and using the standard Error with the t-value to give lower and upper bounds
        double standardError = standardErrorOfMean(standardDeviation, sampleSize);
        double modifier = standardError * theValue;
        System.out.println(theValue);
        System.out.println(standardError);
        System.out.println(modifier);
        HashMap confidenceRange = new HashMap<String, Double>();
        double lowerBound = sampleMean - modifier;
        double upperBound = sampleMean + modifier;

        // Updating HashMap with lower and upperbound and returning.
        confidenceRange.put("Lower Bound", lowerBound);
        confidenceRange.put("Upper Bound", upperBound);

        // Printing the lower and upper bound for the condifence interval if a TRUE flag is passed with the other arguments, else returning.
        if(printFlag){
            System.out.println("The lower bound is: " + confidenceRange.get("Lower Bound"));
            System.out.println("The upper bound is: " + confidenceRange.get("Upper Bound"));
        }

    return confidenceRange;
    }

    public static double fTest(ArrayList<List<Double>> dataValues, boolean printFlag){

        double explainedVariance = 0.0;

        // Calculating the overall average for all datapoints to be later used in explained variance formula.
        double dataOverallMean = 0.0;
        int totalSize = 0;
        for(int i = 0; i < dataValues.size(); i++){
            totalSize += dataValues.get(i).size();
            for(int j = 0; j < dataValues.get(i).size(); j++){
                dataOverallMean += dataValues.get(i).get(j);
            }
        }
        dataOverallMean = dataOverallMean / totalSize;

        // Upodating explainedVariance with, for all arrays, (array length * (array average minus data average squared)) / number of arrays - 1
        for(int i = 0; i < dataValues.size(); i++){
            for(int j = 0; j < dataValues.get(i).size(); j++){
                explainedVariance += (dataValues.get(i).size() * Math.pow((BaseFunctions.mean(dataValues.get(i).toArray(new Double[dataValues.get(i).size()]), "array" )- dataOverallMean), 2)) / (dataValues.size() - 1);
            }
        }

        double unexplainedVariance = 0.0;

        for(int i = 0; i < dataValues.size(); i++)
            for(int j = 0; j < dataValues.get(i).size(); j++){
                unexplainedVariance += Math.pow((dataValues.get(i).get(j) - BaseFunctions.mean(dataValues.get(i).toArray(new Double[dataValues.get(i).size()]), "array")), 2) / (totalSize - dataValues.size());
            }

        double fTestResult = explainedVariance / unexplainedVariance;

        if (printFlag){
            System.out.println("The F statistics is: " + fTestResult);
        }

    return fTestResult;
    }

    public static double fStatistic(Double[] X, Double[] Y){

        // Calculating the sum of squared errors for the x array and the y array
        double f1 = SumOfSquaresOfErrors.theSumOfErrors(X, Y);
        double f2 = SumOfSquaresOfErrors.theSumOfErrors(Y, X);

        // Logical condition: set the largest sum of squared errors to be the numerator and divide by the smaller.
        if (f1 > f2){
            double fStatistic = f1 / f2;
            return fStatistic;
        }
        if (f2 > f1){
            double fStatistic = f2 / f1;
            return fStatistic;
        }
        else{
            return 1.0;
        }
    }

}
