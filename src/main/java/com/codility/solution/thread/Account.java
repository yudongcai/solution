package com.codility.solution.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
	private Lock lock = new ReentrantLock();
	double money;
	
	public void deposit(double m) {
		money += m;
	}
	
	public void withdraw(double m) {
		money -= m;
	}
	
	public double getBalance() {
		return money;
	}
	
	public Lock getLock() {
		return this.lock;
	}

}
