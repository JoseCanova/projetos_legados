package org.nanotek.apachemq;

import java.util.stream.Stream;

import org.nanotek.Base;
import org.nanotek.beans.entity.Url;

public	class WithTicket<B extends Url<B> , T extends Ticket<B,T>> implements Ticket<B,T>{ 
	
	String message;
	
	public WithTicket() { 
		message = "this is the message";
	}
	
	@Override
	public <M extends Base<B>> Stream<?> withTicket(B message) {
		return Ticket.super.withTicket(message);
	}
	
	
	public static void main(String[] args) { 
		WithTicket w = new WithTicket<>();
		Stream<?> u = w.withTicket(new Url<>());
		System.out.println(u.count());
	}
	
}
