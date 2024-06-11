package com.springboot.jpa.Util.practicalProgrammes;

public class FibonacciWithoutRecursion {

	public static int fibonacci(int a, int upto) {
		System.out.println("Fibonacci series:");

		int sum = 0;
		for (int i = a; i < upto; i++) {
			System.out.print(i + " ");
			int b = 1;
			sum = a + b;
			b = sum;
		}
		return sum;

	}

	public static void main(String[] args) {
				
				  int n = 10; // Change the value of n to generate Fibonacci series up to the   desired length
				  
				  System.out.println("Fibonacci series:"); 
				  int a = 0, b = 1; 
				  for (int i = 0; i  < n; i++) 
				  { 
					  System.out.print(a + " "); //0 , 
					   int sum = a + b;  //1 , 2
					   a = b;            //1,1
					   b = sum;          //1,
					   }
				 

		          // System.out.print(fibonacci(10,50));  
	    }
}
