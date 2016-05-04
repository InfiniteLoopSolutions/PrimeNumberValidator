package com.dropwizard.primes.api;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DivideAndConquer {

	private int batchNumber;
	private int start;
	private int finish;
	private int cpu;
		
	public DivideAndConquer(int start, int finish, int batch, int cpu) {
		this.start = start;
		this.finish = finish;
		this.batchNumber = batch;
		this.cpu = cpu;
	}
		
	public Integer compute() throws Exception {

		if(!checkValues())
			return 0;
		
		int sum = 0;
				
		// If it is a large number then we must go the Stream Fork route
		sum = CalculateStreamRoute();
		
		// If it is a small number then use the single Object route
		sum = CalculateSingleThread();
				
		// This will attempt to slice up the range of numbers you are trying to calculate
		if(sum==0)
			sum = calculateBatchMultiTread(start, batchNumber);
		
		return sum;
	}

	private int calculateBatchMultiTread(int newStart, int newFinish) throws InterruptedException, ExecutionException {
		int primeCount = 0;
		// Otherwise go the callable route		
		ExecutorService pool = Executors.newWorkStealingPool(cpu);
				
		// Create the Callable collection
		Set<Future<Integer>> set = new HashSet<Future<Integer>>();
		Future<Integer> future;
		Callable<Integer> callable;
		for (int i = newStart; i <= finish; i++) {
			callable = new SieveOfEratosthenesMinMax(i, i + batchNumber);
			future = pool.submit(callable);
			set.add(future);

			// jump to the next start position
			i = i + newFinish;
			// Make sure we end the loop correctly
			if (i + batchNumber > finish)
				batchNumber = (i + batchNumber) - (i + newFinish - finish);
		}
		// Add up all the outputs
		for (Future<Integer> futureValue : set) {
			primeCount += futureValue.get();
		}
		return primeCount;
	}

	private int CalculateSingleThread() throws Exception {
		if ((finish - start) < batchNumber && batchNumber > 0	) {
			SieveOfEratosthenesMinMax eratosthenes2 = new SieveOfEratosthenesMinMax(start, finish);
			return eratosthenes2.call();
		}
		return 0;
	}

	private int CalculateStreamRoute() throws InterruptedException, ExecutionException {		
		if (finish > Math.sqrt(Integer.MAX_VALUE)) 
			return new CalculatePrimesFork(cpu).ContainsPrimeNumbers(start, finish);

		return 0;
	}
	
	// Check the input values are correct
	private boolean checkValues() {				
		
		boolean passed = true;
		
		if(batchNumber < 1)
			passed = false;
		
		if(start < 1)
			passed = false;
		
		if(start > finish)
			passed = false;
						
		return passed;
	}	
}

