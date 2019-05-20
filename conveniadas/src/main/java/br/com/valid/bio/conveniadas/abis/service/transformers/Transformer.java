package br.com.valid.bio.conveniadas.abis.service.transformers;

import java.util.function.Function;

import br.com.valid.bio.conveniadas.model.Base;

@FunctionalInterface
public interface Transformer<T, S extends Base<?>> extends Function<S,T> {

	@Override
	T apply(S source);

}
