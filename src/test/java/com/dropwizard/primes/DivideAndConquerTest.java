package com.dropwizard.primes;

import com.dropwizard.primes.api.DivideAndConquer;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class DivideAndConquerTest extends TestCase{
	
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DivideAndConquerTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( DivideAndConquerTest.class );
    }
	
    public void test0To101() throws Exception {
		assertTrue(new DivideAndConquer(0, 101, 100, 4).compute().equals(0));
	}
    
    public void test0To100() throws Exception {
		assertTrue(new DivideAndConquer(0, 100, 100, 4).compute().equals(25));
	}
    
    public void test2To100() throws Exception {
		assertTrue(new DivideAndConquer(2, 100, 100, 4).compute().equals(25));
	}
    
	public void test3To100() throws Exception {
		assertTrue(new DivideAndConquer(3, 100, 100, 4).compute().equals(24));
	}	
	
	public void test2To1001() throws Exception {
		assertTrue(new DivideAndConquer(2, 1001, 99, 4).compute().equals(168));
	}
	
	public void test3To1001() throws Exception {
		assertTrue(new DivideAndConquer(3, 1001, 99, 4).compute().equals(167));
	}	
		
	public void test2To10000() throws Exception {
		assertTrue(new DivideAndConquer(1, 10000, 99, 4).compute().equals(1229));
	}
	
	// This is a long test
	public void test2ToMAX_VALUE() throws Exception {
		//assertTrue(new DivideAndConquer(1, Integer.MAX_VALUE, 1000, 4).compute().equals(1229));
	}
}
