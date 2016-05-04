package com.dropwizard.primes.api;

import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.IntStream.*;


public class Java8IntStream {

	public Java8IntStream() {
	}

	public List<Integer> collectPrimes(int max){
		return range(1, max).parallel().filter(this::isPrime).boxed().collect(Collectors.toList());
	}
	
	public int countPrimes(int min, int max){
		return (int) range(min, max).parallel().filter(this::isPrime).count();
	}
	
	public boolean isPrime(int n){
		return n > 1 && rangeClosed(2, (int) Math.sqrt(n)).noneMatch(divisor -> n % divisor == 0);	
	}
}
