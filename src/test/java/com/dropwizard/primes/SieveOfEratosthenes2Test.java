package com.dropwizard.primes;

import com.dropwizard.primes.api.SieveOfEratosthenesMinMax;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SieveOfEratosthenes2Test extends TestCase{
	
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SieveOfEratosthenes2Test(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( SieveOfEratosthenes2Test.class );
    }
	
	public void test3To1001() throws Exception {
		
		SieveOfEratosthenesMinMax sieveOfEratosthenes2 = new SieveOfEratosthenesMinMax(3, 1001);		
		assertTrue(sieveOfEratosthenes2.call() == 167);
		
	}	
	
	public void test2To1001() throws Exception {
		
		SieveOfEratosthenesMinMax sieveOfEratosthenes2 = new SieveOfEratosthenesMinMax(2, 1001);
		assertTrue(sieveOfEratosthenes2.call() == 168);
	}	
}
