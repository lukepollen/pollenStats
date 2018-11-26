/**
 * Created by Luke Pollen of pollenanalytics.com on 05/07/2017.
 */

package pollenStats;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Retrieving the arrays stored in StatisticsData.
        Map<String, Double[]> dataMap = StatisticsData.initializeArrays();

        // Creating and lists of doubles to an arraylist and supplying the arraylist containing these lists to an f Test.
        ArrayList<List<Double>> doubleOfDoubles = new ArrayList<List<Double>>();
        List<Double> inexperiencedRats = Arrays.asList(dataMap.get("Inexperienced Rats"));
        List<Double> experiencedRats = Arrays.asList(dataMap.get("Experienced Rats"));
        doubleOfDoubles.add(inexperiencedRats);
        doubleOfDoubles.add(experiencedRats);
        //Significance.fTest(doubleOfDoubles, true);

        // Calculating the fStatistic by computing the division of the sum of squares of errors, subtracting from individual data points the expected value according the to regression formula bx + a.
        //double theFStatistic = Significance.fStatistic(dataMap.get("Inexperienced Rats"), dataMap.get("Experienced Rats"));
        //System.out.println("The F Statistic for the rats is: " + theFStatistic);


        Double[][] ratArray = new Double[][] {dataMap.get("Inexperienced Rats"), dataMap.get("Experienced Rats")};
        Double[][] khanArray = new Double[][] {{3.0, 2.0, 1.0}, {5.0, 3.0 , 4.0}, {5.0, 6.0, 7.0}};
        /**
        TreeMap testAnova = AnalysisOfVariance.anovaMap(khanArray);
        System.out.println(testAnova.get("F Statistic"));
        TreeMap ratAnova = AnalysisOfVariance.anovaMap(ratArray);
        System.out.println(ratAnova.get("F Statistic"));
        System.out.println(ratAnova.get("SSW Degrees Freedom"));

        System.out.println("\n" + Significance.populationProportion(1.96, 280, 123, true));
        System.out.println(Significance.populationProportion(1.96, 38, 13, true));
         */
        System.out.println("The t statistic for the two means is: " + Significance.twoSampleTTestStatistic(ratArray[1], ratArray[2]));

    }
}

/*

        // "We believe, on average, it takes an untrained rat 150 seconds to run the maze"

        Double[] trainingRats = dataMap.get("Inexperienced Rats");
        HashMap ratValues = Significance.singleTTest(BaseFunctions.mean(trainingRats, "untrained"), 150, BaseFunctions.standardDeviation(trainingRats), trainingRats.length, true);
        List<HashMap<Double, List<Double>>> tableTest = StatisticsData.tValueLookup();

        //Significance.tConfidenceInterval(115, 12, 18, true);
        Significance.tConfidenceInterval(BaseFunctions.mean(trainingRats, "untrained"), BaseFunctions.standardDeviation(trainingRats), trainingRats.length, 0.95, true);

        HashMap testMap = Significance.differenceTwoSampleMeans(dataMap.get("Array One"), dataMap.get("Array Two"), 0.05, false);
        System.out.println(testMap.get("Lower Bound"));
        System.out.println(testMap.get("Upper Bound"));

        // R Equivalent
        //inexperiencedRats = c(126.0, 134.0, 135.0, 139.0, 142.0, 144.0, 145.0, 145.0, 147.0, 149.0, 152.0, 153.0, 156.0)
        //t.test(inexperiencedRats, mu=150)

 */

/*

        // Poker hand probability
        System.out.println((Probabilities.combinations(13, 1) * Probabilities.combinations(4, 3) *
                Probabilities.combinations(12, 2) * Math.pow(Probabilities.combinations(4, 1), 2)) / Probabilities.combinations(52, 5));

        System.out.println((Probabilities.combinations(13, 1) * Probabilities.combinations(4, 3) *
                Probabilities.combinations(12, 4) * Math.pow(Probabilities.combinations(4, 1), 4)) / Probabilities.combinations(52, 7));

        System.out.println((Probabilities.combinations(13, 1) * Probabilities.combinations(4, 3) *
                Probabilities.combinations(12, 4) * Math.pow(Probabilities.combinations(4, 1), 4)));

 */

/*

        // Draw three cards. Probability cards are all of the same suit, two of same suit, all different suits:
        //double sameSuit = (combinations(4, 1)*combinations(13, 3)) / combinations(52, 3);
        //double twoOfSameSuit= (combinations(4, 1)*combinations(13, 2)*combinations(3, 1)*combinations(13, 1)) / combinations(52, 3);
        //double allDifferentSuits = (combinations(4, 3)*Math.pow(combinations(13, 1), 3)) / combinations(52, 3);
        //double total = sameSuit + twoOfSameSuit + allDifferentSuits;
        //System.out.println("Total probability of three card draw, of all the same suits, all different suits, or two of one kind and another of another kind: " + total);

        // Probability of drawing three red cards in a row, without replacement.
        //System.out.println(Probabilities.hyperGeometricProbability(52, 26, 3, 3, false));
        //Double[] trainingRats = dataMap.get("Inexperienced Rats");

 */

/*



 */