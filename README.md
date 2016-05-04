# PrimeNumberValidator


  This is a dropwizard implementation to demonstrate two forms of input, single value and range (min, max). The demonstration is using java 8 and a number of techniques:

  ForkJoinPool,
  IntStream,
  ExecutorService,
  Callables,
  and just raw number crunching!

Maintainer
------------

  [Jude Conroy](https://github.com/Jude-Conroy)


Documentation
------------

  The implementation uses dropwizards fat jar creation which contains all the dependencies it needs to run.
  
  [WIKI](https://github.com/Jude-Conroy/PrimeNumberValidator/wiki)


To compile.


  mvn package


To run, navigate to the app root directory (level containing the prime.yml)

  
  java -jar target/primes-0.0.1-SNAPSHOT.jar server prime.yml


Configuration


  The configuration is contained in the prime.yml file. When the app s running it is accessible on the applicationConnectors port below.

  If running on localhost:
  [Click here to test Single Value Integer.MAX_VALUE](http://localhost:9000/IsPrime?start=21474837)

  Response if of this format
  {"id":1,"isPrime":true,"primeCount":1}

  [Click here to test range Values 1 to 101](http://localhost:9000/ArePrime?rangestart=1&rangeend=101)

  Response if of this format
  {"id":1,"isPrime":true,"primeCount":25}

```xml
defaultCPUNumber: 4

Change default server ports
server:
  applicationConnectors:
  - type: http
    port: 9000
  adminConnectors:
  - type: http
    port: 9001
```

Tests


Tests are included and only test the prime number calculators and processes. I considered it out of scope to test the implementation of the framework.

Dependencies


```xml
<properties>
		<!-- Generic properties -->
		<java.version>1.8</java.version>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<main.class>${project.groupId}.${project.artifactId}.PrimeValidatorApplication</main.class>
		
		<!-- Dw -->
		<dropwizard.version>0.9.2</dropwizard.version>
		
		<!-- Test -->
		<junit.version>4.11</junit.version>

		<!-- Maven plugins -->
		<maven-compiler-plugin.version>3.1</maven-compiler-plugin.version>
		<maven-jar-plugin.version>2.5</maven-jar-plugin.version>
		<maven-shade-plugin.version>2.3</maven-shade-plugin.version>
		<guava.version>18.0</guava.version>
	</properties>
	
	<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
  </dependency>
  <dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-all</artifactId>
    <version>1.9.5</version>
    <scope>test</scope>
  </dependency>
  <!-- CGLIB, only required and used for @Configuration usage -->
  <dependency>
    <groupId>cglib</groupId>
    <artifactId>cglib-nodep</artifactId>
    <version>2.2</version>
    <scope>test</scope>
  </dependency>
```

There is a limit on the range of values for the api of a min-max difference of 100,000,000

One test is commented out test2ToMAX_VALUE() in DivideAndConquerTest as it fails on application start (takes too long).

Tested on Windows, Mac OSX and Linux

Any problems please do get in touch.
