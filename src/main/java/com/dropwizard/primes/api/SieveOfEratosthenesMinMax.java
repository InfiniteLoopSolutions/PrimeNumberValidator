package com.dropwizard.primes.api;

import java.util.concurrent.Callable;

public class SieveOfEratosthenesMinMax implements Callable<Integer> {   
	
	private SieveOfEratosthenes sieve;
	private int primes;
	private int start; 
	private int finish;
	
	public SieveOfEratosthenesMinMax(int start, int finish)
	{
		this.start = start;
		this.finish = finish;
		sieve = new SieveOfEratosthenes();
	}	
	
	@Override
	public Integer call() throws Exception {
		
		checkStartValue();
				
        for(int i = start; i <= finish; i=i+2)
        	if(sieve.sieve(i))
        		primes++; 
        
        return primes;        
	}

	private void checkStartValue() {				
						
		if(start > 0 && start < 3)
		{
			primes++;
			start = 3;
		}
		
		if((start & 1) == 0 ) 
			start = start+1;
	}		
}
