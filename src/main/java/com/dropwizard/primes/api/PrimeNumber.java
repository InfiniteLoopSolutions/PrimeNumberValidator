package com.dropwizard.primes.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrimeNumber {
    
	private long id; 
	
    private boolean isPrime;
    
    
    private int primeCount;

    public PrimeNumber() {
        // Jackson deserialization
    }
    
    public PrimeNumber(long id) {
        this.id = id;
    }

    @JsonProperty
    public long getId() {
        return id;
    }
    
    @JsonProperty
    public boolean getIsPrime() {
        return isPrime;
    }
    
    @JsonProperty
    public void setIsPrime(boolean isPrime) {
        this.isPrime = isPrime;
    }

    @JsonProperty
    public long getPrimeCount() {
		return primeCount;
	}

    @JsonProperty
    public void setPrimeCount(int primeCount) {
		this.primeCount = primeCount;
	}
}