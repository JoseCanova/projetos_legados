package br.com.valid.bio.conveniadas.abis.service.key;

public abstract class BaseKeyService<K> implements KeyService<K> {

	@Override
	public Class<? extends Object> getKeyClass() {
		return   getClass().getSuperclass().getInterfaces()[0].getTypeParameters()[0].getGenericDeclaration();
	}
}