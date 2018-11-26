/**
 * Created by Luke Pollen of pollenanalytics.com on 05/07/2017.
 */

package pollenStats;

import java.util.Map;
import java.util.stream.Stream;

public class TestArea {

    public static Map<String, Double[]> dataMap = StatisticsData.initializeArrays();

    public static double pythonTest() {

        double theTest = 0.0;

    return theTest;
    }

    /*
    public static double testCorrelation(String arrayOne, String arrayTwo){

        // Setting the initial correlation to a double of 0.0:
        double theCorrelation = 0.0;

        // Retrieving arrays:
        Double[] x = dataMap.get(arrayOne);
        Double[] y = dataMap.get(arrayTwo);

        // Retrieving values for sxx, syy, sxy:
        // Calculates variance by  (((sum of xth - x mean) * (sum of yth - ymean)) / array length -1)
        double testSxy = PearsonCoefficent.covariance(arrayOne, arrayTwo);
        // Standard deviations of X and Y
        double testSxx = BaseFunctions.standardDeviation(x);
        double testSyy = BaseFunctions.standardDeviation(y);;

        // Covariance / (x standard deviation * y standard deviation)
        theCorrelation += testSxy / (testSxx * testSyy);
        System.out.println(theCorrelation);

    return theCorrelation;
    }
    */


}
