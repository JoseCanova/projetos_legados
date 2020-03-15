package org.nanotek.beans.csv;

import java.io.Serializable;
import java.util.Optional;
import java.util.function.Consumer;

import org.nanotek.Base;
import org.nanotek.Holder;
import org.nanotek.ImmutableBase;

public abstract class HolderBaseBean<ID extends Serializable> extends BaseBean<ID> implements Holder<HolderBaseBean<?>> {

	private static final long serialVersionUID = 8211224453324863096L;

	public HolderBaseBean() {
	}
	
	@Override
	public <B extends Base<?>> Optional<B> on(Consumer<HolderBaseBean<?>> k) {
		k.accept(this);
		return ImmutableBase.
	}
	
}
