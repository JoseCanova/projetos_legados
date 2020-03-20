package org.nanotek.beans.csv;

import java.io.Serializable;

import org.nanotek.entities.Mutables;

public  interface BaseBean<K extends BaseBean<K,I> , I extends Serializable> extends Mutables<K,I>{
}
