package com.dropwizard.primes.core;

import com.dropwizard.primes.health.PrimeApplicationHealthCheck;
import com.dropwizard.primes.resources.CheckPrimeNumberResource;
import com.dropwizard.primes.resources.CheckPrimeNumbersRangeResource;
import com.dropwizard.primes.resources.PrimeMultiThreadedResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class PrimeValidatorApplication extends Application<PrimeValidatorConfiguration> {
		    	    		
	private static final String CONFIGURATION_FILE = "prime.yml";

    public static void main(String[] args) throws Exception {
      new PrimeValidatorApplication().run(new String[]{"server", CONFIGURATION_FILE});
    }
    
    @Override
    public void initialize(Bootstrap<PrimeValidatorConfiguration> bootstrap) {                  
    }
       
    @Override
    public void run(PrimeValidatorConfiguration configuration, Environment environment) throws Exception { 
    	
    	final PrimeApplicationHealthCheck healthCheck =
    	        new PrimeApplicationHealthCheck(configuration.getDefaultCPUNumber(), configuration.getBatchNumber(),
    	        		configuration.getRangesSpreadMax());
    	    environment.healthChecks().register("template", healthCheck);
    	    
    	environment.jersey().register(new CheckPrimeNumberResource());     
    	environment.jersey().register(new CheckPrimeNumbersRangeResource(configuration.getDefaultCPUNumber(),
    									configuration.getRangesSpreadMax()));     
    	environment.jersey().register(new PrimeMultiThreadedResource(configuration.getBatchNumber(), 
    									configuration.getDefaultCPUNumber(), configuration.getRangesSpreadMax()));     	
    }
}

