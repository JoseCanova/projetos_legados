package org.nanotek.stream;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

import org.nanotek.Base;
import org.nanotek.BaseException;
import org.nanotek.beans.entity.Area;

public class KongStream<K extends Base<?>> implements KongStreamBuilder<K> {
	
	Class<K> clazz;
	
	ArrayList<K> iterable;
	
	@Override
	public void accept(K value) {
		Class<?> classe = clazz;
		Optional.ofNullable(value).filter(v -> value.getClass().equals(classe)).orElseThrow(BaseException::new);
		iterable.add(value);
	}

	@Override
	public Builder<K> add(K t) {
		 accept(t);
		 return this;
	}
	
	@Override
	public Stream<K> build() {
		return iterable.stream();
	}
	
	private KongStream(Class<K> clazz) {
		iterable = new  ArrayList<K>();
		this.clazz = clazz;
	}

	public static  <K extends Base<?>> KongStream<K> of(Class<K> clazz) {
		return new KongStream<K>(clazz);
	}
	
	public static void main (String[] args) {
		Area area = new Area();
		KongStream.of(Area.class).add(area).build().forEach(a -> System.out.println(a.withUUID().toString()));;
	}
}

