/**
 * Created by Luke Pollen of pollenanalytics.com on 05/07/2017.
 */

package pollenStats;

public class SumOfSquaresOfErrors {

    public static double theSumOfErrors(Double[] x, Double[] y){

        double sumOfErrors = 0;
        for(int i = 0; i < x.length; i++){
            sumOfErrors += y[i] - (pointEstimate(y[i], x, y) * pointEstimate(y[i], x, y));
        }

    //System.out.println(sumOfErrors);
    return sumOfErrors;
    }

    public static double pointEstimate(double xith, Double[] x, Double[] y){

        double thePointEstimate = (beta(x, y) * xith) + alpha(x, y);

    //System.out.println(thePointEstimate);
    return thePointEstimate;
    }

    public static double alpha(Double[] x, Double[] y){

        double yMean = BaseFunctions.mean(y, "y");
        double xMean = BaseFunctions.mean(x, "x");
        double beta = beta(x, y);
        double alpha = yMean - (beta * xMean);

    //System.out.println(alpha);
    return alpha;
    }

    public static double beta(Double[] x, Double[] y){

        // Variables to populate via arithmetic operations in the loop
        double xTotal = 0;
        double yTotal = 0;
        double xTimesY = 0;
        double xSquaresSum = 0.0;

        // Updating total value of arrays and calculating the sum of the ith parts.
        for (int i = 0; i < x.length; i++) {
            xTotal += x[i];
            yTotal += y[i];
            xTimesY += x[i] * y[i];
            xSquaresSum += x[i] * x[i];
        }

        // Calculation of sXY and sXX
        double sXY = xTimesY - ((xTotal * yTotal) / x.length);
        double xSumSquared = xTotal * xTotal;
        double sXX = xSquaresSum - (xSumSquared / x.length);

        // Updating sum of array squared divided by length of array for x and the sum of the individual squares
        double beta = sXY / sXX;

    return beta;
    }

}
