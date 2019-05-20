package br.com.valid.bio.conveniadas.abis.service;

import org.springframework.stereotype.Component;

import br.com.valid.bio.conveniadas.abis.exception.AbisRuntimeException;

/**
 * Simply execute the thread.sleep  method changing the Exception by a RuntimeException.
 * @author jose.canova
 */

@Component
public class ThreadHolder {

	public ThreadHolder() {
	}
	
	
	public void hold(Long milliseconds) { 
		try { 
				Thread theThread = Thread.currentThread();
				hold(theThread , milliseconds);
		}catch (InterruptedException iex) {
			throw new AbisRuntimeException (iex);
		}
	}

	private void hold(Thread theThread, Long milliseconds) throws InterruptedException {
		Thread.sleep(milliseconds);
	}

}
