package br.com.valid.bio.conveniadas.abis.service.transformers.response;

import br.com.valid.bio.conveniadas.abis.model.response.AbstractResponse;
import br.com.valid.bio.conveniadas.model.RequestBase;

public abstract class RequestBaseResponseTransformer<U extends RequestBase , S extends AbstractResponse> extends AbstractBaseResponseTransformer<U , S> {
}
