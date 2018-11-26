/**
 * Created by Luke Pollen of pollenanalytics.com on 05/07/2017.
 */

package pollenStats;

import java.util.*;

public class StatisticsData {

    public static Map<String, Double[]> initializeArrays(){

        // Container for storing the Double arrays and their String names
        Map<String, Double[]> dataArrays = new TreeMap<String, Double[]>();

        // The Arrays
        Double[] experiencedRats = new Double[]{118.0, 120.0, 121.0, 125.0, 126.0, 127.0, 128.0, 129.0, 130.0, 130.0, 131.0, 132.0, 135.0, 137.0};
        Double[] inexperiencedRats = new Double[] {126.0, 134.0, 135.0, 139.0, 142.0, 144.0, 145.0, 145.0, 147.0, 149.0, 152.0, 153.0, 156.0, 158.0};
        Double[] testOne = new Double[]{2.0, 4.0, 8.0, 16.0, 32.0, 64.0};
        Double[] testTwo = new Double[] {12.0, 14.0, 18.0, 26.0, 32.0, 64.0};
        Double[] testThree = new Double[] {24.0, 28.0, 36.0, 52.0, 64.0, 128.0};
        Double[] testFour = new Double[] {4.7, 3.8, 3.4, 3.5, 4.1, 4.3, 4.0, 3.8};
        Double[] testFive = new Double[] {8.0, 13.0, 9.0, 11.0, 13.0};
        Double[] xOne = new Double[] {3.0, 4.0, 6.0, 8.0, 10.0};
        Double[] yOne = new Double[] {4.0, 5.0, 7.0, 10.0, 10.0};
        Double[] dummyDataOne = new Double[] {44.0, 51.0, 52.0, 55.0, 60.0, 62.0, 66.0, 68.0, 69.0, 71.0, 71.0, 76.0, 82.0, 91.0, 108.0};
        Double[] dummyDataTwo = new Double[] {52.0, 64.0, 68.0, 74.0, 79.0, 83.0, 84.0, 88.0, 95.0, 97.0, 101.0, 116.0};

        // Loading the map.
        dataArrays.put("Experienced Rats", experiencedRats);
        dataArrays.put("Inexperienced Rats", inexperiencedRats);
        dataArrays.put("Test One", testOne);
        dataArrays.put("Test Two", testTwo);
        dataArrays.put("Test Three", testThree);
        dataArrays.put("Test Four", testFour);
        dataArrays.put("Test Five", testFive);
        dataArrays.put("xOne", xOne);
        dataArrays.put("yOne", yOne);
        dataArrays.put("Array One", dummyDataOne);
        dataArrays.put("Array Two", dummyDataTwo);

        //double[] test = new double[] {1, 2, 3};
        // Returning the map. This class is usually instantiated via Main for the subsequent function calls.
        return dataArrays;

    }

    public static List<HashMap<Double, List<Double>>> tValueLookup(){

        // Key significance values based on a two tailed test. For single tail, divide the key value by 2.
        List<HashMap<Double, List<Double>>> tValues = new ArrayList<HashMap<Double, List<Double>>>();
        HashMap<Double, List<Double>> mapOfDoubles = new HashMap<Double, List<Double>>();
        mapOfDoubles.put(0.20, Arrays.asList(0.378, 1.886, 1.638, 1.533, 1.476, 1.440, 1.415, 1.397, 1.383, 1.372, 1.363, 1.356, 1.350, 1.345, 1.341, 1.337, 1.333, 1.330, 1.328, 1.325));
        mapOfDoubles.put(0.10, Arrays.asList(6.314, 2.290, 2.353, 2.131, 2.015, 1.943, 1.895, 1.860, 1.833, 1.812, 1.796, 1.782, 1.771, 1.761, 1.753, 1.746, 1.740, 1.734, 1.729, 1.725));
        mapOfDoubles.put(0.05, Arrays.asList(12.706, 4.303, 3.182, 2.776, 2.571, 2.447, 2.365, 2.306, 2.262, 2.228, 2.201, 2.179, 2.160, 2.145, 2.131, 2.120, 2.110, 2.101, 2.093, 2.086, 2.080, 2.074, 2.069, 2.064, 2.060));
        mapOfDoubles.put(0.025, Arrays.asList());
        mapOfDoubles.put(0.01, Arrays.asList());
        mapOfDoubles.put(0.005, Arrays.asList());
        mapOfDoubles.put(0.0005, Arrays.asList());
        tValues.add(mapOfDoubles);

        /*
        HashMap firstMap = tValues.get(0);
        List<Double> theFirst = (List<Double>) firstMap.get(0.10);
        Double theValue = theFirst.get(2);
        System.out.println(theValue);
        */

    return tValues;
    }

}
