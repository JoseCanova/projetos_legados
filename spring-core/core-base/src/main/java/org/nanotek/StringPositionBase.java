package org.nanotek;

public class StringPositionBase<K extends StringBase<K>,ID extends IdBase<ID,K> , P extends Positionable<P,ID>> extends PositionBase<ID,K,P> {

	private static final long serialVersionUID = -6208474088768715766L;
	
	
	public StringPositionBase(ID immutable) {
		super();
	}

	
	public  static void main(String[] args) {
		
	}


	@Override
	public K getId() {
		return null;
	}


	@Override
	public P getPosition() {
		return null;
	}

}
