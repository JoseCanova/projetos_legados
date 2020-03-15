package org.nanotek.beans.csv;

import java.io.Serializable;

import org.nanotek.Mutables;

public  abstract class BaseBean<K extends Serializable> implements Mutables<K>{

	private static final long serialVersionUID = 1939354964505054726L;

	public BaseBean() {
	}
}
