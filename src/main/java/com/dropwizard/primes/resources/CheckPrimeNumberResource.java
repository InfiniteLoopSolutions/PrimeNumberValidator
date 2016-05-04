package com.dropwizard.primes.resources;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.dropwizard.primes.api.CalculatePrimeNumbers;
import com.dropwizard.primes.api.PrimeCounterAdder;
import com.dropwizard.primes.api.PrimeNumber;

@Path("IsPrime")
@Produces(MediaType.APPLICATION_JSON)
public class CheckPrimeNumberResource {
	
    private final AtomicLong counter;
           
    public CheckPrimeNumberResource() {       
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public PrimeNumber isThisNumberPrime(@QueryParam("start") int numberToCheck) {  
    	    	
    	PrimeNumber primer = new PrimeNumber(counter.incrementAndGet());
    	primer.setIsPrime(new CalculatePrimeNumbers().isPrimeNumber(numberToCheck));  
    	
    	if(primer.getIsPrime())
    		primer.setPrimeCount(1);     	    	
    	
    	return primer;
    }   
}