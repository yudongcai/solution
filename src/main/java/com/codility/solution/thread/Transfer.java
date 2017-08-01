package com.codility.solution.thread;

import java.util.concurrent.TimeUnit;

public class Transfer implements Runnable {
	Account a;
	Account b;
	double m;
	
	
	public Transfer(Account a, Account b, double money) {
		this.a = a;
		this.b = b;
		this.m = money;
	}

	/*//dead lock!!
	@Override
	public void run1() {
		synchronized (a) {
			a.withdraw(money);
			synchronized (b) {
				b.deposit(money);
			}
		}
		
	}*/
	
	@Override
	public void run() {
		try {
			if (a.getLock().tryLock(10, TimeUnit.SECONDS) 
					&& b.getLock().tryLock(10, TimeUnit.SECONDS)) {
				a.withdraw(m);
				b.deposit(m);
			} else {
				//log can't hold the lock
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			a.getLock().unlock();
			b.getLock().unlock();
		}
	}

}
