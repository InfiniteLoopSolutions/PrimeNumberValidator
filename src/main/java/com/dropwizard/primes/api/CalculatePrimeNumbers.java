package com.dropwizard.primes.api;

public class CalculatePrimeNumbers {
		
	SieveOfEratosthenes sieve;
	
	public boolean isPrimeNumber(int numberToCheck)	{
		
		sieve = new SieveOfEratosthenes();
		
		if(numberToCheck < 2)
			return false;
		
		if(Integer.MAX_VALUE == numberToCheck)
			return true;
								
		return sieve.sieve(numberToCheck);		
	}
}
