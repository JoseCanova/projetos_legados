package org.nanotek.opencsv;

import org.apache.commons.beanutils.WrapDynaBean;
import org.nanotek.Id;
import org.nanotek.WrappedEntityBase;
import org.nanotek.beans.csv.ArtistBean;
import org.nanotek.beans.csv.BaseBean;

public class WrappedBaseClass <K extends BaseBean<?>> extends WrapDynaBean implements WrappedEntityBase<K> , Id<K>{

	private static final long serialVersionUID = 1676627942338335870L;

	K id;
	
	public WrappedBaseClass(K instance) {
		super(instance);
	}

	
	@Override
	public K getId() {
		return id;
	}

	public static void main(String[] args) {
//		WrappedBaseClass w = new WrappedBaseClass(ArtistBean.class);
	}
	
}
