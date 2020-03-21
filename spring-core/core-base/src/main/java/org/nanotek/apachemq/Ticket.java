package org.nanotek.apachemq;

import java.util.stream.Stream;

import org.nanotek.Base;
import org.nanotek.stream.KongStream;

public interface Ticket<B extends T , T extends Base<?>> extends Base<B>{

	default Stream<?> withTicket(B message){
		return KongStream.of(message.getClass().asSubclass(Base.class)).add(message).build();
	}
	
}
