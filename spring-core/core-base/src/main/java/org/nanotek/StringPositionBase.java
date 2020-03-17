package org.nanotek;

public class StringPositionBase<K extends StringBase<K>,ID extends IdBase<ID,K> , P extends PositionableEntityBase<P,ID>> extends PositionBase<ID,K,P> {

	private static final long serialVersionUID = -6208474088768715766L;
	
	K id; 
	
	P position;
	
	public StringPositionBase() {
		super();
	}

	@Override
	public K getId() {
		return id;
	}

	@Override
	public ID getPosition() {
		return null;
	}


}
