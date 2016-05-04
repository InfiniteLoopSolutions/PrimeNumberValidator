package com.dropwizard.primes.api;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class CalculatePrimesFork {

	private boolean isPrime;
	private ForkJoinPool forkJoinPool;
	
	public CalculatePrimesFork(int cpuCores){	
		forkJoinPool = new ForkJoinPool(cpuCores);
	}

	public int ContainsPrimeNumbers(int start, int finish) throws InterruptedException, ExecutionException
	{		
		int primeCount = forkJoinPool.submit(() -> new Java8IntStream().countPrimes(start, finish)).get();	
		forkJoinPool.shutdown();
		
		return primeCount;
	}
	
	public boolean IsPrimeNumber(int numberToCheck) throws InterruptedException, ExecutionException
	{		
		isPrime = forkJoinPool.submit(() -> new Java8IntStream().isPrime(numberToCheck)).get();	
		forkJoinPool.shutdown();
		
		return isPrime;
	}
}
