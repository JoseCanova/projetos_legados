package org.nanotek;

import org.apache.commons.beanutils.WrapDynaBean;
import org.nanotek.beans.csv.BaseBean;
import org.nanotek.beans.entity.Artist;

public class WrappedBaseClass <K extends BaseBean<?>> extends WrapDynaBean implements WrappedEntityBase<K> , Id<K>{

	private static final long serialVersionUID = 1676627942338335870L;

	K id;
	
	public WrappedBaseClass(Class<K> clazz) {
		super(WrappedEntityBase.newWrappedInstance(clazz));
	}

	@Override
	public K getId() {
		return id;
	}

	public static void main(String[] args) {
		WrappedBaseClass w = new WrappedBaseClass(Artist.class);
		System.out.println(w.getId());
	}
	
}
