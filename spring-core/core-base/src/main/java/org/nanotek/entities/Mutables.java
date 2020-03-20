package org.nanotek.entities;

import java.io.Serializable;

import org.nanotek.IdBase;

public interface Mutables<K extends Mutables<K,ID>,ID extends Serializable>  extends  MutableBase<ID>{
}
