package com.springboot.jpa.Util.practicalProgrammes;

public class YieldSleepJoinThreads {
	
public static void main(String[] args) throws InterruptedException {
	
	ChildThread childThread = new ChildThread();
	childThread.start();
	childThread.setPriority(1);
	
	
	ChildThread2 childThread2 = new ChildThread2();
	childThread2.start();
	childThread.setPriority(1);
	//childThread2.yield();
	//childThread.join();
	
	ChildThread childThread3 = new ChildThread();
	//childThread3.start();
	System.out.println(childThread.currentThread().getName());
	childThread.setPriority(5);
}
}

