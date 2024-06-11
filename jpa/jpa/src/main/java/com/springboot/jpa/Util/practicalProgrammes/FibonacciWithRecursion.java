package com.springboot.jpa.Util.practicalProgrammes;

public class FibonacciWithRecursion {
	

	    public static void main(String[] args) {
	        int n = 10; // Change the value of n to generate Fibonacci series up to the desired length
	        System.out.println("Fibonacci series:");
	        for (int i = 0; i < n; i++) {
	            System.out.print(fibonacci(i) + " ");
	        }
	    }

	    // Recursive method to calculate Fibonacci number
	    public static int fibonacci(int n) {
	        if (n <= 1) {
	            return n; // Base case: return 0 for n = 0, return 1 for n = 1
	        } else {
	            // Recursive case: Fibonacci(n) = Fibonacci(n-1) + Fibonacci(n-2)
	            return fibonacci(n - 1) + fibonacci(n - 2);
	        }
	    }
	}
	    


