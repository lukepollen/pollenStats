# pollenStats
An implementation of common statistical functions in Java.

This package will help you explore your data with the following functionality:

Least squares regressions for determining a line of best fit for data points mapped on an X and Y axis. 
    - https://www.khanacademy.org/math/ap-statistics/bivariate-data-ap/least-squares-regression/v/regression-residual-intro
    
Calculation of the Pearson coefficent, used to determine the least squares regression formula for two variables, which is the correlation between two variables, and calculation of the covariance, a measure of the joint variability of two random variables.
    - https://statistics.laerd.com/statistical-guides/pearson-correlation-coefficient-statistical-guide.php
    - https://en.wikipedia.org/wiki/Covariance    

Probability and culumative probability functions for working with the discrete binomial, poisson and hypergeometric probability distributions. 
    Binomial functions - (For an introduction to the binomial distribution, see https://www.youtube.com/watch?v=qIzC1-9PwQo)
        
        Allows the user to determine  the binomial probability for x successes in n trials for some probability p and a binomial                 culumative probably which calculates the culumative probability of, out of n trials, culumative number of successes, given               probability p. 
    Poisson functions - (For an introduction to the poisson distribution, see https://www.youtube.com/watch?v=jmqZG6roVqU)    
        
        Allows calculation, defined in terms of events in time period (lambda) and the time period to be measured(timePeriod). For               example, if a call centre receieves 7 calls every 5 minutes. What is the probability of 5 calls in 3.6 minutes? The culumative           poisson probability function, given a time period and rate of events, checks over a new period the probability of > or < X               events. For example, over a one minute period, with an average of 3 events, checks likehood of there being, during a two minute         period, > 1 event.
        
        A poisson-normal z score, with a continuity correction to the normal distribution to approximate the probability of events               bounded over time and space. https://onlinecourses.science.psu.edu/stat414/node/180/ gives the example of calculating the               probability of > 9 earthquakes with an epicentre of 40 miles to downtown Mephis, given a mean of 6.5 annually.
        
    Hypergeometric probability - (For an introduction to the hypergeometic distribution, see 
    https://www.youtube.com/watch?v=L2KMttDm3aY)     
        Hypergeometric distribution for calculation of the "probability of k successes (random draws for which the object drawn has a           specified feature) in n draws, without replacement, from a finite population of size N that contains exactly  K objects with             that feature" - https://en.wikipedia.org/wiki/Hypergeometric_distribution. An example use would be hyperGeometricProbability(52,         4, 5, 2) // What are the odds of two kings in a poker hand of 5 cards? This calculation would make the following effective calls         to combinations: (combinations(4, 2)*combinations(48, 5-2))/combinations(52,5);
        
Measures of statistical significance (non Bayesian) which can be used in hypothesis testing. 
    Standard error of mean
    
    Two sample t test statistic
    
    Two sample t test confidence interval
    
    Population proportion (with confidence interval)
    
    Population sample single t test
    
    Difference of two sample means
    
    Z-score significance test
        When all population values are known and normally distributed, A z score can be calculated which determines the probability of           seeing an event as extreme, or greater, than the event we have seen. If the mean weight of a packet of crisps is 100g, with a           standard deviation of 15g and we observe an average weight of 145g of a sample, then this sample has a z score of 3; 99.99% of           values fall below this range, so there was a 0.001% chance of randomly chosing a sample as extreme. Therefore, we would conclude         at the 99% significance level that the true mean is not 100g or the sample was not drawn from our population.

Some other mathematical functions are included which may prove of use, including:
    Functions which return the total possible number of permutations, combinations for n and k, and factorial value,
    Truth tables of an arbitary size can be generated to check boolean values of combinations of premises.    

