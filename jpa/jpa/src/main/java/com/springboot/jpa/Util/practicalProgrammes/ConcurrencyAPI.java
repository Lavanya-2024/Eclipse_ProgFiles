package com.springboot.jpa.Util.practicalProgrammes;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrencyAPI {

	    public static void main(String[] args) {
	    	
	        ExecutorService executor = Executors.newFixedThreadPool(2);

	        for (int i = 0; i < 20; i++) {
	            int finall = i;
	            executor.submit(() -> System.out.println(Thread.currentThread().getName() + " is executing task " + finall));
	        }
	        executor.shutdown();
	    }
	}

//interface Executor
//class Executors 

//interface ExecutorService extends Executor 
//