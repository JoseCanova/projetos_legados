package org.nanotek;

import java.util.Optional;
import java.util.function.Predicate;

public class Result<K extends IdBase<?>> implements BooleanBase<K , Boolean> {

	private static final long serialVersionUID = -307344888633306177L;
	
	private Boolean id;
	
	private K result;

	public Result() {}
	
	public Result(Boolean value , K result) { 
		this.id = value;
		this.result = result;
	}

	public Boolean getId() {
		return id;
	}

	public K getResult() {
		return result;
	}

	@Override
	public <B extends Base<?>> Optional<Result<?>> on(Predicate<K> k) {
		return Optional.of(new Result<>(k.test(result) , result));
	}

}
