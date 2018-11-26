/**
 * Created by Luke Pollen of pollenanalytics.com on 05/07/2017.
 */

package pollenStats;

import java.util.Map;
import java.util.stream.Stream;

public class LeastSquares {


    public static void regressionLine(String arrayOne, String arrayTwo) {

        // Retrieving the dataMap held in StatisticsData
        Map<String, Double[]> dataMap = StatisticsData.initializeArrays();

        // Calculating standard deviations for respective arrays
        double xDeviation = BaseFunctions.standardDeviation(dataMap.get(arrayOne));
        System.out.println(xDeviation);
        double yDeviation = BaseFunctions.standardDeviation(dataMap.get(arrayTwo));
        System.out.println(yDeviation);

        // Converting the Double arrays in dataMap to their primitive types
        double[] x = Stream.of(dataMap.get(arrayOne)).mapToDouble(Double::doubleValue).toArray();
        double[] y = Stream.of(dataMap.get(arrayTwo)).mapToDouble(Double::doubleValue).toArray();

        // Retrieving the values required to calculate a and b, respectively.
        double correlationCoefficent = PearsonCoefficent.correlationCoeff(arrayOne, arrayTwo);
        double a = correlationCoefficent * (yDeviation / xDeviation);
        double xMean = BaseFunctions.mean(dataMap.get(arrayOne), "x");
        double yMean = BaseFunctions.mean(dataMap.get(arrayTwo), "y");
        double bOne = yMean - a*xMean;
        System.out.println("Y hat is " + a + "x" + " + "+ bOne);

    }

    public static void regressionLineAlternative(String arrayOne, String arrayTwo){

        // Retrieving the dataMap held in StatisticsData
        Map<String, Double[]> dataMap = StatisticsData.initializeArrays();

        // Converting the Double arrays in dataMap to their primitive types
        double[] x = Stream.of(dataMap.get(arrayOne)).mapToDouble(Double::doubleValue).toArray();
        double[] y = Stream.of(dataMap.get(arrayTwo)).mapToDouble(Double::doubleValue).toArray();
        double numerator = BaseFunctions.sumXTimesY(arrayOne, arrayTwo) - (x.length *(BaseFunctions.mean(dataMap.get(arrayOne), "x")) * BaseFunctions.mean(dataMap.get(arrayTwo), "y"));
        double denominator = (BaseFunctions.sumArraySquared(arrayOne) - (x.length*(BaseFunctions.mean(dataMap.get(arrayOne), "x") * BaseFunctions.mean(dataMap.get(arrayOne), "x"))));
        double m = numerator / denominator;
        double b = BaseFunctions.mean(dataMap.get(arrayTwo), "y") - (m * (BaseFunctions.mean(dataMap.get(arrayOne), "x")));

        System.out.println("Y hat is " + m + "x + " + b);

    }

}
