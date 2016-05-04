package com.dropwizard.primes.core;

import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class PrimeValidatorConfiguration extends Configuration {
	
	@NotNull
    private int defaultCPUNumber;
	
	@NotNull
    private int batchNumber;
	
	@NotNull
    private int rangesSpreadMax;
  
    @JsonProperty
    public int getDefaultCPUNumber() {
        return defaultCPUNumber;
    }

    @JsonProperty
    public void setDefaultCPUNumber(int name) {
        this.defaultCPUNumber = name;
    }

	public int getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(int batchNumber) {
		this.batchNumber = batchNumber;
	}

	public int getRangesSpreadMax() {
		return rangesSpreadMax;
	}

	public void setRangesSpreadMax(int rangesSpreadMax) {
		this.rangesSpreadMax = rangesSpreadMax;
	}    
}
