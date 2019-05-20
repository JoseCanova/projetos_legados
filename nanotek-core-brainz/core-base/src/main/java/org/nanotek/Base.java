package org.nanotek;

import java.io.Serializable;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

import org.nanotek.beans.ArtistCredit;

public interface Base<K extends Serializable> extends Identifiable <K>  {

	public void setId(K id);
	
	default <T> T newAnyType(Supplier<T> supplier)
	{ 
		return supplier.get();
	}
	
	default <T> T ofNullable(T dest , Supplier<T> supplier) 
	{ 
		return Optional.ofNullable(dest).orElseGet(supplier); 
	}
	
	default <T extends Base<?>> T newType(Supplier<T> baseSupplier)
	{ 
		return baseSupplier.get();
	}
	
	public static void main(String args[])
	{   ArtistCredit ac = new ArtistCredit();
		System.out.println(ac.getArtistCreditNames());
		System.out.println(ac.getArtistCreditNames());
	}
}
