package br.com.valid.bio.conveniadas.abis.service.key;

public interface KeyService<K> {
	
	public K getKey();
	public Class<? extends Object> getKeyClass();
	
}
