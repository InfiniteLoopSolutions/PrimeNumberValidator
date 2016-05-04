package com.dropwizard.primes.api;

import java.util.concurrent.atomic.LongAdder;

public class PrimeCounterAdder {
	
	private final LongAdder adder = new LongAdder();
	
	public int getCounter()
	{
		return adder.intValue();
	}
	
	public void increment()
	{
		adder.increment();
	}
	
	public void add(int primes)
	{
		adder.add(primes);
	}
}

