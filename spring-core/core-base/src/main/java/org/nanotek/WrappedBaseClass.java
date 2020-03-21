package org.nanotek;

import java.util.stream.Stream;

import org.apache.commons.beanutils.WrapDynaBean;
import org.nanotek.beans.entity.Artist;
import org.nanotek.stream.KongStream;

public class WrappedBaseClass <K extends IdBase<K,ID>,ID extends IdBase<ID,?> > extends WrapDynaBean implements IdBase<K,ID> , WrappedEntityBase<K> {

	private static final long serialVersionUID = 1676627942338335870L;

	Entity<ID> instanceEntity;
	
	Stream<ID> stream;
	
	public WrappedBaseClass(Class<ID> clazz) {
		super(IdBase.prepareBeanInstance(clazz));
		mountStreamBaseStream(clazz);
	}
	private void mountStreamBaseStream(Class<ID> clazz) {
		stream = KongStream.of(clazz).add(clazz.cast(getInstance())).build();
	}

	@Override
	public ID getId() {
		return (ID) stream.findFirst().orElseThrow(BaseException::new);
	}

	public static void main(String[] args) {
		WrappedBaseClass w = new WrappedBaseClass(Artist.class);
		System.out.println(w.getId());
	}
	
}
