package org.nanotek;

import org.apache.commons.beanutils.WrapDynaBean;

public class WrappedBaseClass <K extends Base<?>> extends WrapDynaBean implements Base<K>{

	private static final long serialVersionUID = 1676627942338335870L;

	public WrappedBaseClass(K instance) {
		super(instance);
	}

}
