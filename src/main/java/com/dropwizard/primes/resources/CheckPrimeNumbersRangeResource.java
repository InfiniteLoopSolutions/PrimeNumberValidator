package com.dropwizard.primes.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.dropwizard.primes.api.CalculatePrimesFork;
import com.dropwizard.primes.api.PrimeNumber;

import java.security.InvalidAlgorithmParameterException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;

@Path("ArePrime")
@Produces(MediaType.APPLICATION_JSON)
public class CheckPrimeNumbersRangeResource {
	
	private static final String THE_RANGE_MUST_BE_LESS_THAN = "The range must be less than ";
    private final AtomicLong counter;    
    private final int cpus;
    private final int rangesSpreadMax;
          
    public CheckPrimeNumbersRangeResource(int cpus, int rangesSpreadMax) {       
        this.counter = new AtomicLong();
        this.cpus =cpus;
        this.rangesSpreadMax = rangesSpreadMax;
    }

    @GET
    @Timed
    public PrimeNumber isThisNumberPrime(@QueryParam("rangestart") int rangeStart, @QueryParam("rangeend") int rangeEnd) throws InterruptedException, ExecutionException, InvalidAlgorithmParameterException {        
            	    	
    	if(rangeEnd - rangeStart > rangesSpreadMax)
    		throw new InvalidAlgorithmParameterException(THE_RANGE_MUST_BE_LESS_THAN + rangesSpreadMax);
    	       	
    	PrimeNumber primer = new PrimeNumber(counter.incrementAndGet());
    	primer.setPrimeCount(new CalculatePrimesFork(cpus).ContainsPrimeNumbers(rangeStart, rangeEnd));    
    	primer.setIsPrime(primer.getPrimeCount() > 0); 
    	    	
    	return primer;
    }   
}