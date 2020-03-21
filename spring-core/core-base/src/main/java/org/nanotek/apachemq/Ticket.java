package org.nanotek.apachemq;

import java.util.stream.Stream;

import org.nanotek.Base;
import org.nanotek.stream.KongStream;

public interface Ticket<B extends Base<B> , T extends Base<T>> extends Base<T>{

	default <M extends Base<B>> Stream<?> withTicket(B message){
		return KongStream.of(message.getClass()).add(message).build();
	}
	
}
