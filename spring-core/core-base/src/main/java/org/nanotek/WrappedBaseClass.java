package org.nanotek;

import org.apache.commons.beanutils.WrapDynaBean;

public class WrappedBaseClass <K extends IdBase<?,ID>, ID extends IdBase<ID,?>> extends WrapDynaBean {

	private static final long serialVersionUID = 1676627942338335870L;

	
	public WrappedBaseClass(ID instance) {
		super(instance);
	}

}
