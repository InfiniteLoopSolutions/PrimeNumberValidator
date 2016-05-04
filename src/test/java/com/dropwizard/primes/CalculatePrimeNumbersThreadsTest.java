package com.dropwizard.primes;

import com.dropwizard.primes.api.CalculatePrimeNumbers;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CalculatePrimeNumbersThreadsTest extends TestCase{
	
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CalculatePrimeNumbersThreadsTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CalculatePrimeNumbersThreadsTest.class );
    }
    
	public void testIntegerMin() {	
	    assertFalse(new CalculatePrimeNumbers().isPrimeNumber(Integer.MIN_VALUE));
	}
	
	public void testIntegerSigned() {	
	    assertFalse(new CalculatePrimeNumbers().isPrimeNumber(Integer.MIN_VALUE+1));
	}
    
	public void test0() {			
	    assertFalse(new CalculatePrimeNumbers().isPrimeNumber(0));
	}
	    
    public void test2() {			
	    assertTrue(new CalculatePrimeNumbers().isPrimeNumber(2));
	}
    
    public void test7() {			
	    assertTrue(new CalculatePrimeNumbers().isPrimeNumber(7));
	}
    
	public void test8() {	    
	    assertFalse(new CalculatePrimeNumbers().isPrimeNumber(8));
	}	
		
	public void test97() {			
	    assertTrue(new CalculatePrimeNumbers().isPrimeNumber(97));
	}
	
	public void test98() {			
	    assertFalse(new CalculatePrimeNumbers().isPrimeNumber(198));
	}
	
	public void testMaxMinus1() {			
	    assertFalse(new CalculatePrimeNumbers().isPrimeNumber(Integer.MAX_VALUE-1));
	}
		
	public void testIntegerMax() {	
	    assertTrue(new CalculatePrimeNumbers().isPrimeNumber(Integer.MAX_VALUE));
	}
}
