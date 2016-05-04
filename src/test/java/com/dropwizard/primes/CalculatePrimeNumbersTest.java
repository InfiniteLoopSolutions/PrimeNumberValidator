package com.dropwizard.primes;

import java.util.concurrent.ExecutionException;

import com.dropwizard.primes.api.CalculatePrimesFork;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CalculatePrimeNumbersTest  extends TestCase{
	
	private int valueToCalc = 10;
	private int cpus = 4;
	
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CalculatePrimeNumbersTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CalculatePrimeNumbersTest.class );
    }
    
    public void testMaxMin() throws InterruptedException, ExecutionException {		
		assertFalse(new CalculatePrimesFork(cpus).IsPrimeNumber(Integer.MIN_VALUE));
	}
	
    public void test0() throws InterruptedException, ExecutionException {
		assertFalse(new CalculatePrimesFork(cpus).IsPrimeNumber(0));
	}
    
	public void test3() throws InterruptedException, ExecutionException {
		assertTrue(new CalculatePrimesFork(cpus).IsPrimeNumber(3));
	}	

	public void test9() throws InterruptedException, ExecutionException {		
		assertFalse(new CalculatePrimesFork(cpus).IsPrimeNumber(9));
	}
	 	
	public void evaluate10() throws InterruptedException, ExecutionException {		
		assertFalse(new CalculatePrimesFork(cpus).IsPrimeNumber(10));
	}	

	public void evaluate13() throws InterruptedException, ExecutionException {		
		assertTrue(new CalculatePrimesFork(cpus).IsPrimeNumber(13));
	}	

	public void evaluate97() throws InterruptedException, ExecutionException {		
		assertTrue(new CalculatePrimesFork(cpus).IsPrimeNumber(97));
	}
		
	public void evaluate1000000() throws InterruptedException, ExecutionException {		
		assertFalse(new CalculatePrimesFork(cpus).IsPrimeNumber(valueToCalc*100000));			
	}
	
	public void evaluate10000000() throws InterruptedException, ExecutionException {		
		assertFalse(new CalculatePrimesFork(cpus).IsPrimeNumber(valueToCalc*1000000));
	}
	
	public void evaluate100000000() throws InterruptedException, ExecutionException {		
		assertFalse(new CalculatePrimesFork(cpus).IsPrimeNumber(valueToCalc*10000000));
	}
	
	public void testMaxMax() throws InterruptedException, ExecutionException {	
		assertTrue(new CalculatePrimesFork(cpus).IsPrimeNumber(Integer.MAX_VALUE));
	}			

	public void test2147483647PlusOne() throws InterruptedException, ExecutionException {		
		assertFalse(new CalculatePrimesFork(cpus).IsPrimeNumber(2147483647+1));
	}	
}
