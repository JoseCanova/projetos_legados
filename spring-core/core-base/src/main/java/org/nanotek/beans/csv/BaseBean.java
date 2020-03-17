package org.nanotek.beans.csv;

import java.io.Serializable;

import org.nanotek.IdBase;
import org.nanotek.Mutables;

public  interface BaseBean<K extends IdBase<K,I> , I extends Serializable> extends Mutables<K,I>{
}
