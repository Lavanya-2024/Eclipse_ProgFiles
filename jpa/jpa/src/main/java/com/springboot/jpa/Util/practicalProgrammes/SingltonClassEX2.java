package com.springboot.jpa.Util.practicalProgrammes;

public class SingltonClassEX2 {

	// Java program implementing Singleton class
	// with using getInstance() method

	// Static variable reference of single_instance of type Singleton
	private static SingltonClassEX2 abc = null;

	// Constructor -- Here we will be creating private constructor
	// restricted to this class itself
	private SingltonClassEX2() {

	}

	// Static method to create instance of ABC class
	public static synchronized SingltonClassEX2 getInstance() {
		if (abc == null)
			abc = new SingltonClassEX2();

		return abc;
	}

	public static void main(String args[]) {
		// Instantiating Singleton class (ABC) with variable abc2
		SingltonClassEX2 abc2 = SingltonClassEX2.getInstance();

		// Instantiating Singleton class (ABC) with variable abc3
		SingltonClassEX2 abc3 = SingltonClassEX2.getInstance();

		// Printing the hash code for above variable as declared

		System.out.println("Hashcode of abc is " + abc.hashCode());
		System.out.println("Hashcode of abc2 is " + abc2.hashCode());
		System.out.println("Hashcode of abc3 is " + abc3.hashCode());

		// Condition check
		if (abc == abc2 && abc2 == abc3) {

			// Print statement
			System.out.println("Three objects point to the same memory location on the heap i.e, to the same object");
		}

		else {
			// Print statement
			System.out.println("Three objects DO NOT point to the same memory location on the heap");
		}
	}

}
