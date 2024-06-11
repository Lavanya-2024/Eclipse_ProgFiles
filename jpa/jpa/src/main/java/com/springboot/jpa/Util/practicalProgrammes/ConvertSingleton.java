package com.springboot.jpa.Util.practicalProgrammes;

public class ConvertSingleton {

	    // Private static instance variable to hold the single instance of the class
	     private static ConvertSingleton instance;

	    // Private constructor to prevent instantiation from outside the class
	    // Constructor implementation    
	    private ConvertSingleton()
	    {
	    	
	    }
	   
	   // Public static method to provide access to the single instance of the class
	   
	    // Lazy initialization: create the instance if it doesn't exist
	   
	    private static synchronized ConvertSingleton getinstance()
	    {
	    	if(instance==null)
	    	{
	    		instance = new ConvertSingleton();
	    	}
			return instance;
	    }
	    
	      // Other methods and variables can be added as needed
	
 
	    public static void main(String[] args) {
			
	    	
	     ConvertSingleton obj= 	ConvertSingleton.getinstance();
			System.out.println(obj.hashCode());  //1523554304
	    	
		ConvertSingleton obj2= 	ConvertSingleton.getinstance();
				System.out.println(obj2.hashCode()); 	
		}
	    
	    
}
