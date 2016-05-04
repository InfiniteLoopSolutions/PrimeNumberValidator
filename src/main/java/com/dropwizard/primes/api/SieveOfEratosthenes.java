package com.dropwizard.primes.api;

public class SieveOfEratosthenes
{   
	SieveOfEratosthenes(){}
		
	// A stripped down function. No collections just returning true if the number is prime.	
    public boolean sieve(int number)
    {    	
    	// Fast even number test.
        if(number > 2 && (number & 1) == 0)
        	return false;
        
        /*
         * If a number n is not a prime, it can be factored into two factors a and b: n = a*b
         * If both a and b were greater than the square root of n, a*b would be greater than n. 
         * So at least one of those factors must be less or equal to the square root of n, and 
         * to check if n is prime, we only need to test for factors less than or equal to the square root.
         */	              
        for(int i = 3; i <= Math.sqrt(number); i += 2)
        	if (number % i == 0) 
        		return false;
                
        return true;
    }
}
