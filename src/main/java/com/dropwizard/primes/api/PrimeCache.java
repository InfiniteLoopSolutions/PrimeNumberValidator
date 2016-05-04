package com.dropwizard.primes.api;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class PrimeCache {

	private AtomicInteger highestNumber;
	private ConcurrentHashMap<String, Integer> concurrentHashMapObject = null;
	
	private PrimeCache() {

		concurrentHashMapObject = new ConcurrentHashMap<String, Integer>();
		highestNumber = new AtomicInteger();
	}

	/* pre-initialized instance of the singleton */
	private static final PrimeCache INSTANCE = new PrimeCache();

	/* Access point to the unique instance of the singleton */
	public static PrimeCache getInstance() {
		return INSTANCE;
	}
	
	public void add(int prime) {
		if (prime > getHighestNumber())
			highestNumber.set(prime);

		if (!concurrentHashMapObject.containsKey(Integer.toString(prime)))
			concurrentHashMapObject.put(Integer.toString(prime), prime);
	}

	public Collection<Integer> Get() {
		return concurrentHashMapObject.values();
	}


	public boolean getPopulated() {
		return concurrentHashMapObject != null && concurrentHashMapObject.size() > 0;
	}

	public int getHighestNumber() {
		return highestNumber.get();
	}
}
