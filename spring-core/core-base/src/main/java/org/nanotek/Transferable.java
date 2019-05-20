package org.nanotek;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Supplier;

import javax.validation.constraints.NotNull;

import org.nanotek.Base;

public interface Transferable {

	static <S extends Base<?> ,  SOURCE extends Collection<S>, DEST extends Collection<S>>
	DEST transferElements(
			@NotNull SOURCE sourceCollection,
			@NotNull Supplier<DEST> collectionFactory) {

		DEST result = collectionFactory.get();
		
		sourceCollection.stream().forEach(p -> result.add(Optional.of(p).filter(t -> t.getId() !=null).get()));
		
		return result;
	}
}
