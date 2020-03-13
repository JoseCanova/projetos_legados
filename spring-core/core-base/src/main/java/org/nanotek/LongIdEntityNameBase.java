package org.nanotek;

public interface LongIdEntityNameBase extends IdNameBase<Long,String> {
	
	@Override
	default Long getId() {
		return get().getId();
	}
	
	@Override
	default void setId(Long id) {
		get().setId(id);
	}
	
	@Override
	default IdBase<Long> withId(Long id) {
		return get().withId(id);
	}
	
	default String getName() { 
		return get().getName();
	}
	
	@Override
	default void setName(String n) { 
		get().setName(n);
	}
	
	@Override
	default LongIdEntityNameBase get() {
		return this;
	}
	
}
