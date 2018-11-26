package pollenStats;

public class CorrelationCoefficent {

    public static Double correlationCoefficentCalculator(Double[] x, Double[] y){

        int length = x.length; // Assumes that the users has passed arrays passed are of the same length
        // Declaring integers of zero so the loops at the start of the function
        Double xSum = elementsSum(x);
        System.out.println("xSum: " + xSum);
        Double ySum = elementsSum(y);
        System.out.println("ySum: " +ySum);
        Double sumXElementsSquared = elementsSquared(x);
        System.out.println("xSum Squared: " + sumXElementsSquared);
        Double sumYElementsSquared = elementsSquared(y);
        System.out.println("ySum Squared: " + sumYElementsSquared);

        // Iterating through the arrays using their xth and yth values to calculate sum of products.
        Double xyProductSummed = 0.0;
        for(int i = 0; i < length; i++){
            Double xValue = x[i];
            Double yValue = y[i];
            Double xyProduct = xValue * yValue;
            xyProductSummed += xyProduct;
            System.out.println(xyProduct);
        }

        System.out.println("xyProduct: " + xyProductSummed);
        // Calculating the sValues for the correlationCoefficent
        Double sxx = sValues(sumXElementsSquared, xSum, length);
        System.out.println("The value for sxx is: " + sxx);
        Double syy = sValues(sumYElementsSquared, ySum, length);
        System.out.println("The value for syy is: " + syy);
        Double sxy = xyProductSummed - ((xSum*ySum)/length);
        System.out.println("The value for sxy is: " + sxy);
        System.out.println("Product of xSum and ySum, divided by n: " + (xSum*ySum)/length);
        // Performing the final calculation using the sxx, syy, sxy values:
        Double theCorrelationCoefficent = sxy / (Math.sqrt(sxx*syy));

    return theCorrelationCoefficent;
    }

    public static Double sValues(Double sumIndividualSquares, Double sum, int length){

        Double sumSquared = sum * sum;
        Double sValue = sumIndividualSquares - (sumSquared / length);

    return sValue;
    }

    public static Double elementsSum(Double[] a){
        // Returns the sum of all the elements in an array.
        Double initialValue = 0.0;
        for(int i = 0; i < a.length; i++){
            Double arrayElement = a[i];
            initialValue += arrayElement;
        }
        return initialValue;
    }

    public static Double elementsSquared(Double[] a){
        // Returns the sum resulting from squaring each element in an array
        Double initialValue = 0.0;
        for(int i = 0; i < a.length; i++){
            Double arrayElement = a[i];
            initialValue += arrayElement * arrayElement;
        }
        return initialValue;
    }

}
