package br.com.valid.bio.conveniadas.abis.service.transformers.response;

import java.util.function.BiFunction;

public interface ResponseTransformer<U , S , T> extends BiFunction<U , S , T> {
}
