/**
 * Created by Luke Pollen of pollenanalytics.com on 05/07/2017.
 */

package pollenStats;

import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by dulce-senorita on 09/07/2017.
 */
public class PearsonCoefficent {

        public static Map<String, Double[]> dataMap = StatisticsData.initializeArrays();

        public static double correlationCoeff(String arrayOne, String arrayTwo){

            // Importing the datamap
            //public Map<String, Double[]> dataMap = StatisticsData.initializeArrays();

            // Converting arrays to their primitive form
            double[] x = Stream.of(dataMap.get(arrayOne)).mapToDouble(Double::doubleValue).toArray();
            double[] y = Stream.of(dataMap.get(arrayTwo)).mapToDouble(Double::doubleValue).toArray();
            double sXY = sumXAndY(arrayOne, arrayTwo);
            double baseSxx = remainingSValues(arrayOne);
            double baseSyy = remainingSValues(arrayTwo);
            double theCoefficent = sXY / Math.sqrt((baseSxx * baseSyy));;

            // Returns correlation coefficent of two arrays.
            return theCoefficent;
        }

        public static double sumXAndY(String arrayOne, String arrayTwo){

            double culumative = 0.0;
            double[] x = Stream.of(dataMap.get(arrayOne)).mapToDouble(Double::doubleValue).toArray();
            double[] y = Stream.of(dataMap.get(arrayTwo)).mapToDouble(Double::doubleValue).toArray();
            for (int i = 0; i < x.length; i++) {
                culumative += (x[i] - BaseFunctions.mean(dataMap.get(arrayOne), "x"))*(y[i] - BaseFunctions.mean(dataMap.get(arrayTwo), "y"));
            }

            return culumative;
        }

        public static double covariance(String arrayOne, String arrayTwo){

            // Returns sum of each array element minus the array mean, multiplied together, divided by array length.
            double theCovariance = sumXAndY(arrayOne, arrayTwo) / (dataMap.get(arrayOne).length -1);

        return theCovariance;
        }

        public static double meanDifferenceSquared(String arrayOne){

            double culumative = 0.0;
            double[] x = Stream.of(dataMap.get(arrayOne)).mapToDouble(Double::doubleValue).toArray();
            for (int i = 0; i < x.length; i++) {
                culumative += (x[i] - BaseFunctions.mean(dataMap.get(arrayOne), "x"));
            }
            culumative = culumative * culumative;

        return culumative;
    }

        public static double remainingSValues(String arrayName){

            double culumative = 0.0;
            double[] s = Stream.of(dataMap.get(arrayName)).mapToDouble(Double::doubleValue).toArray();
            for (int i = 0; i < s.length; i++) {
                culumative += (s[i] - BaseFunctions.mean(dataMap.get(arrayName), "s")) * (s[i] - BaseFunctions.mean(dataMap.get(arrayName), "s"));
            }
            return culumative;
        }

    }



