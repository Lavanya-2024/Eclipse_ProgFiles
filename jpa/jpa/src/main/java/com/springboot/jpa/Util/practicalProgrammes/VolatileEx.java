package com.springboot.jpa.Util.practicalProgrammes;

public class VolatileEx {
	public static volatile int b = 0;

	public static void main(String[] args) {
	 
	b= 500;	
		
	ChildThread childThread = new ChildThread();
	ChildThread2 childThread2 = new ChildThread2();
	
	childThread.start();
	//childThread2.start();
	
	System.out.println(b);
	
	}
}


	class ChildThread extends Thread {
		@Override
		public void run() {
			try {
				ChildThread.sleep(30000);
				System.out.println("Child1 thread");
				VolatileEx.b = 100;
				System.out.println("b value is "+ VolatileEx.b);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
	}
	
		class ChildThread2 extends Thread {
			@Override
			public void run() {
				System.out.println("Child2 thread");
				VolatileEx.b = 200;
                System.out.println("child2 -b value is "+ VolatileEx.b);
			}
		}
	

