package com.newgig.logic;

import java.util.concurrent.Semaphore;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Scope("prototype")
public class LogicLocker {

	private static final int DEFAULT_PERMITS = 1;
	public Semaphore semaphore = new Semaphore(DEFAULT_PERMITS);
	
	public LogicLocker (int permits) {
		this.semaphore = new Semaphore(permits);
	}
	
	@After("@annotation(com.newgig.logic.annotation.Lock)")
	public void release() {
		semaphore.release();
	}

	@Before("@annotation(com.newgig.logic.annotation.Lock)")
	public void acquire() {
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}