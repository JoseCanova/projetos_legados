package org.nanotek.integration.tune;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Supplier;

import org.nanotek.beans.musicbrainz.TuneRelease;
import org.nanotek.ws.xml.ArtistRelease;

public interface TuneReleaseTransferable extends Transferable {

	static <S extends ArtistRelease ,  SOURCE extends Collection<S>, DEST extends Collection<TuneRelease>>
	DEST transferElements(
			SOURCE sourceCollection,
			Supplier<DEST> collectionFactory) {

		DEST result = collectionFactory.get();

		sourceCollection.stream().forEach(p -> result.add(Optional.of(transform(p)).filter(t -> nullIdValue(t)).get()));

		return result;
	}

	static <S extends ArtistRelease , T extends TuneRelease>
	TuneRelease transform(ArtistRelease s)
	{ 
		return new TuneRelease(s);
	}

	static 
	boolean nullIdValue ( TuneRelease t )
	{ 
		return t.getId() !=null;
	}
}
