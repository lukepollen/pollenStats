/**
 * Created by Luke Pollen of pollenanalytics.com on 05/07/2017.
 */

package pollenStats;

/**
 * Created by dulce-senorita on 07/07/2017.
 */
public class Probabilities {

    public static double factorial(double factorialValue) { // Needs updating to return real number values correctly.

        if (factorialValue == 0) {
            return 1;
        } else {
            // Initializing theFactorial with a value of one.
            double theFactorial = 0;

            // Iterating through a loop to calculate the factorial values.
            for (int i = 1; factorialValue > 0; i++) {
                if (theFactorial == 0) {
                    theFactorial = 1 * factorialValue;
                    factorialValue -= 1;
                } else {
                    theFactorial = theFactorial * factorialValue;
                    factorialValue -= 1;
                    //System.out.println(theFactorial);
                }
            }
            //System.out.println(theFactorial);
            return theFactorial;
        }
    }

    public static double combinations(double n, double k) {

        // Calls permutations, then divides the integer returned by k factorial:
        double theCombinations = 0;

        // Calling permutations and dividing by the choose factorial.
        if (k != 0) {
            try {
                theCombinations = permutations(n, k) / factorial(k);
            } catch (ArithmeticException e) {
                theCombinations = permutations(n, k) / 1;
            }

            //System.out.println(theCombinations);
            return theCombinations;
        }
        else {
            return 1;
        }

    }

    public static double permutations(double n, double k){

        // Calculates permutations using the n! / (n-k)! formula:
        double thePermutations = 0;

        try {
            thePermutations = factorial(n) / factorial(n - k);
        }
        catch (ArithmeticException e) {
            thePermutations = factorial(n) / 1;
        }

    return thePermutations;
    }

    public static double binomialProbability(int n, int x, double p){

        //n indicates the number of trials.
        //x indicates number of successes.
        //p is the probability of a successful trial.

        // Using the formula (n choose x)(p^x)(1 - p^(n-x)):
        double theProbability = combinations(n, x) * (Math.pow(p, x) * ((Math.pow((1-p), (n-x)))));

    return theProbability;
    }

    public static double binomialCulumativeProbability(int n, double p, int culumative){

        // Calculates the culumative probability of, out of n trials, culumative number of successes, given probability p
        // Example Use: binomialCulumativeprobability(28, 0.1, 5) // Given n 0.1% success rate, calculates the probability of 0-5 successes out of 28 trials.
        double theProbability = 0.0;
        // Will count up to the total number of successes. Used as an argument for the calculation of each respective probability.
        int count = 0;
        for (int i = 0; i < culumative + 1; i++) {
            theProbability += binomialProbability(n, count, p);
            count += 1;
        }

    return theProbability;
    }

    public static double poissonProbability(int timePeriod, int lambda, int testPeriod, int events){

        //Defined in terms of events, time period (lambda) and the time period to be measured(timePeriod)
        // Example use: callcentre receieves 7 calls every 5 minutes. What is the probability of 5 calls in 3.6 minutes? poissonProbability(5, 7, 3.6, 5)
        double newTimePeriod = testPeriod / timePeriod;
        double newLambda = lambda * newTimePeriod;
        double probability = ((Math.pow(newLambda, events)) * (Math.pow(Math.E, (0-newLambda)))) / factorial(events);
        //System.out.println(probability);

    return probability;
    }

    public static double poissonCulumativeProbability(int timePeriod, int lambda, int testPeriod, int events, boolean moreThan){

        // Given a time period and rate of events, checks over a new period the probability of > or < X events.
        // Example Use: poissonCulumativeProbability(1, 3, 2, 1, true) Over a one minute period, with an average of 3 events, checks likehood of there being, during a two minute period, > 1 event.

        // Initializing the initial probability to zero:
        double probability = 0.0;
        // Initializing the culumative probability to zero:
        double culumativeProbability = 0.0;

        if (moreThan) {
            for (int i = 0; i < events; i++) {
                // Given p time where q events usually occur, the probability that x events will be occur in y time period,
                culumativeProbability += poissonProbability(1, 3, 2, i);
                System.out.println(culumativeProbability);
            }

            // Subtracting the culumative probability of each event from the total probability of the event space, which is one.
            probability = 1 - culumativeProbability;

            return probability;
        }
        else {
            for (int i = 0; i < events; i++) {
                // Given p time where q events usually occur, the probability that x events will be occur in y time period,
                culumativeProbability += poissonProbability(1, 3, 2, i);
                //System.out.println(culumativeProbability);
            }

            // Subtracting the culumative probability of each event from the total probability of the event space, which is one.
            probability = culumativeProbability;

            return probability;
        }
        //populating culumativeProbability via calls to poissonProbability within the following loop:

    }

    public static double poissonNormalZScore (int timePeriod, int lambda, int events, String type){

        // Uses a continuity correction to the normal distribution to approximate the probability of events bounded over time and space.
        // Example Use: poissonToNormal(7, 3, 25, "<")

        // Calculating the total events, considering lambda and the time period.
        int averageEvents = timePeriod * lambda;
        double correctionValue = 0.0;

        // Adjusts the correctionValue for the continuity correction, based on
        if (type.equals(">")){
            correctionValue += 0.5;
        }
        else if (type.equals(">=")) {
            correctionValue -= 0.5;
        }
        else if (type.equals("<=")) {
            correctionValue += 0.5;
        }
        else {
            correctionValue -= 0.5;
        }

        // Applying continuity correction so the returned Z value is closer to the actual z value associated with the sum of the probabilities.
        double continuityCorrection = events + correctionValue;
        // Calculating the Z value, given the continuity correction
        System.out.println(continuityCorrection);
        System.out.println(averageEvents);
        double zValue =(continuityCorrection - averageEvents) / Math.sqrt(averageEvents);

    return zValue;
    }

    public static double hyperGeometricProbability (int totalObjects, int typeOne, int selectionSize, int xChosen, boolean isCulumative) {

        // Example Use: hyperGeometricProbability(52, 4, 5, 2) // What are the odds of two kings in a poker hand of 5 cards?
        // Makes the following effective calls to combinations: (combinations(4, 2)*combinations(48, 5-2))/combinations(52,5);

        // Computing the typeTwo objects.
        int typeTwo = totalObjects - typeOne;

        // If the culumative argument is set, iteratively add the probability of choosing i type one objects (sampling without replacement)
        if (isCulumative) {
            // Setting theProbability to zero, as the value will update with each iteration of the forthcoming loop.
            double theProbability = 0.0;
            for(int i = 0; i <= xChosen; i++){
                theProbability += (combinations(typeOne, i) * combinations(typeTwo, selectionSize - i))/combinations(totalObjects, selectionSize);
                //System.out.println(theProbability);
            }
        return theProbability;
        }
        else{
            // Updating theProbaility with calls to combinations in order to return hyperGeometric properties.
            double theProbability = (combinations(typeOne, xChosen) * combinations(typeTwo, selectionSize - xChosen)) / combinations(totalObjects, selectionSize);
        return theProbability;
        }
    }

}
