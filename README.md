# pollenStats
## An implementation of common statistical functions in Java.
### This package will help you explore your data with the following functionality:

### Discovering standard statistical values relating to the shape and central measures of your distribution:
    *Mean - Average value
    *Median - Middle value if all values are ordered (50th percentile)
    *Interquantile ranges - 25th and 75th percentiles.
    *Standard deviation - A measure of how much values deviate from the mean. 
        The mean, +- 3 standard deviations, covers 99% of a distribution (if normally distributed).
    *Variance - The square of the standard deviation.

![java-stats-central-tendency](https://github.com/lukepollen/pollenStats/blob/master/centralTendency.png)
![java-stats-std-distribution-shape](https://github.com/lukepollen/pollenStats/blob/master/std-dev-low-high.png)
### Least squares regressions for determining a line of best fit for data points mapped on an X and Y axis. 
    -(https://www.khanacademy.org/math/ap-statistics/bivariate-data-ap/least-squares-regression/v/regression-residual-intro)
 
![java-stats-linear-regression](https://github.com/lukepollen/pollenStats/blob/master/linearRegression.png)
### Calculation of the Pearson coefficent, used to determine the least squares regression formula for two variables, which is the correlation between two variables, and calculation of the covariance, a measure of the joint variability of two random variables.
    - (https://statistics.laerd.com/statistical-guides/pearson-correlation-coefficient-statistical-guide.php)
    - (https://en.wikipedia.org/wiki/Covariance)  
    
![java-stats-pearson-coefficent-covariance](https://github.com/lukepollen/pollenStats/blob/master/pearson-coeff-bcon.jpg)
### Probability and culumative probability functions for working with the discrete binomial, poisson and hypergeometric probability distributions. 
    *Binomial functions - (For an introduction to the distribution, see (https://www.youtube.com/watch?v=qIzC1-9PwQo)
    Allows the user to determine  the binomial probability for x successes in n trials for some probability p and a 
    binomial culumative probability which calculates the culumative probability of, out of n trials, culumative number
    of successes, given probability p. 
    
    -*Poisson functions* - (For an introduction to the distribution, see (https://www.youtube.com/watch?v=jmqZG6roVqU)    
    Allows calculation, defined in terms of events in time period (lambda) and the time period to be measured(timePeriod).
    For example, if a call centre receieves 7 calls every 5 minutes. What is the probability of 5 calls in 3.6 minutes? 
    The culumative poisson probability function, given a time period and rate of events, checks over a new period the 
    probability of > or < X events. For example, over a one minute period, with an average of 3 events, checks likehood of 
    there being, during a two minute period, > 1 event.
    
    A poisson-normal z score, with a continuity correction to the normal distribution to approximate the probability of 
    events bounded over time and space. (https://onlinecourses.science.psu.edu/stat414/node/180/) gives the example of 
    calculating the probability of > 9 earthquakes with an epicentre of 40 miles to downtown Mephis, given a mean of 6.5
    annually.
    
    *Hypergeometric probability 
    (For an introduction to the distribution, see (https://www.youtube.com/watch?v=L2KMttDm3aY)     
    Hypergeometric distribution for calculation of the "probability of k successes (random draws for which the object drawn
    has a specified feature) in n draws, without replacement, from a finite population of size N that contains exactly  K 
    objects with that feature" - (https://en.wikipedia.org/wiki/Hypergeometric_distribution). An example use would be
    hyperGeometricProbability(52, 4, 5, 2) // What are the odds of two kings in a poker hand of 5 cards? 
    This calculation would make the following effective calls to combinations: 
        (combinations(4, 2)*combinations(48, 5-2))/combinations(52,5);

![java-stats-discrete-distributions](https://github.com/lukepollen/pollenStats/blob/master/binomial%20geometric%20negative%20binomial.jpg)
![java-stats-poisson-distributions](https://github.com/lukepollen/pollenStats/blob/master/xpoisson-distribution-formula.png)
### Measures of statistical significance (non Bayesian) which can be used in hypothesis testing. 
    *Standard error of mean
     A probabilistic statement about how the sample size will provide a better bound on estimates of the population mean,
     in light of the central limit theorem; the standard error of the sample mean is an estimate of how far the sample mean
     is likely to be from the population mean, whereas the standard deviation of the sample is the degree to which individuals
     within the sample differ from the sample mean. If the population standard deviation is finite, the standard error of the 
     mean of the sample will tend to zero with increasing sample size, because the estimate of the population mean will improve,
     while the standard deviation of the sample will tend to approximate the population standard deviation as on sample size increase.       
    *Two sample t test statistic
     Generally used to test the null hypothesis two population means from two random samples (from an approximately normal
     distribution) are equal.    
     
    *Two sample t test confidence interval
     Used to calculate a range that we are x% certain that the true mean is within this range. Varies depending on significance
     level desired.
     
    *Population proportion (with confidence interval) - https://en.wikipedia.org/wiki/Population_proportion
     Wherein a census of a population is not possible, which is often the case in any "real world" application, a 
     population proportion is estimated through an observational study / experiment. Invoking the central limit theorem
     with the sampling distribution being approximately normal, it is possible to substitute the value for the proportion
     of observations in the sample, the number of samples and the significance level into a calculation of the range 
     containing the true proportion, with our desired level of confidence.  
     
    *Population sample single t test
     Determines whether a given sample of data could have been generated via a process with a given mean. Given a hypothesis,
     e.g. a manufacturer of packets of crisps states that the mean weight of each bag is 100g, a random sample could be 
     collected and the value of t statistic computed. A t value with a modulus greater than the theorised value at our given
     significant value means we may reject the null hypothesis in favour of the alternative hypothesis.    
     
    *Difference of two sample means       
     A two sample z test which is used to determine if two population means are equal or unequal. Similar to the two sample t
     test, although the degrees of freedom differ (All points are known if we know the entire population values).
     
    *Z-score significance test
     When all population values are known and normally distributed, A z score can be calculated which determines the 
     probability of seeing an event as extreme, or greater, than the event we have seen. If the mean weight of a packet
     of crisps is 100g, with a standard deviation of 15g and we observe an average weight of 145g of a sample, then this
     sample has a z score of 3; 99.99% of values fall below this range, so there was a 0.001% chance of randomly chosing
     a sample as extreme. Therefore, we would conclude at the 99% significance level that the true mean is not 100g or the
     sample was not drawn from our population.
     
    *F-Test
     There are a number of uses of F Tests for testing hypothesis:
     The hypothesis that the means of a given set of normally distributed populations, all having the same standard deviation,
     are equal. This is perhaps the best-known F-test, and plays an important role in the analysis of variance (ANOVA).
     The hypothesis that a proposed regression model fits the data well. See Lack-of-fit sum of squares.
     The hypothesis that a data set in a regression analysis follows the simpler of two proposed linear models that are nested
     within each other.

![java-stats-z-test](https://github.com/lukepollen/pollenStats/blob/master/hypothesis-testing-z-test-ttest-ftest-11-638.jpg)
![java-stats-paired-t-test](https://github.com/lukepollen/pollenStats/blob/master/t-test-paired1_orig.png)
### Analysis of Variance
    Returns a map describe the total sum of squares, the sum of squares degrees freedom, the sum of the squares within,
    the sum of the squares between, the sum of squares between degrees of freedom and the F statistic for this data.

![java-stats-anova](https://github.com/lukepollen/pollenStats/blob/master/anova.gif)
### Some other mathematical functions are included which may prove of use, including:
    Functions which return the total possible number of permutations, combinations for n and k, and factorial value,
    Truth tables of an arbitary size can be generated to check boolean values of combinations of premises.    

![java-sats-permutations-combinations-factorial](https://github.com/lukepollen/pollenStats/blob/master/math-combinations-permutations.png)
