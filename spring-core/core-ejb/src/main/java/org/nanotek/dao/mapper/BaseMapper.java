package org.nanotek.dao.mapper;

import java.util.function.Function;

import org.nanotek.Base;

public interface BaseMapper<T extends Base<?>, Serializable>  extends Function<T,Serializable> {
}
