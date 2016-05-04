package com.dropwizard.primes.health;

import com.codahale.metrics.health.HealthCheck;

public class PrimeApplicationHealthCheck extends HealthCheck {
    
	private final int cpuNumber;
	private final int batchNumber;
	private final int rangeSpread;
		
	public PrimeApplicationHealthCheck(int cpu, int batchNumber, int rangeSpread) {
		super();
		this.cpuNumber = cpu;
		this.batchNumber = batchNumber;
		this.rangeSpread = rangeSpread;
	}
	
    @Override
    protected Result check() throws Exception {
    	
        if (cpuNumber < 1) {
            return Result.unhealthy("yml config doesn't include defaultCPUNumber.");
        }
        
        if (batchNumber < 1) {
            return Result.unhealthy("yml config doesn't include batchNumber.");
        }
        
        if (rangeSpread < 1) {
            return Result.unhealthy("yml config doesn't include rangeSpread.");
        }
        return Result.healthy();
    }
}