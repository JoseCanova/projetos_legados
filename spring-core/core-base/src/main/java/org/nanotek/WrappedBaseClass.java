package org.nanotek;

import org.apache.commons.beanutils.WrapDynaBean;

public class WrappedBaseClass <K extends IdBase<K,ID>,ID extends IdBase<ID,?> > extends WrapDynaBean implements IdBase<K,ID> {

	private static final long serialVersionUID = 1676627942338335870L;

	
	public WrappedBaseClass(Class<ID> instance) {
		super(Base.newInstance(instance));
	}


	@Override
	public ID getId() {
		return (ID) instance;
	}

}
