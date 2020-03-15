package org.nanotek.beans.csv;

import java.io.Serializable;

import org.nanotek.IdBase;

public abstract class HolderBaseBean<ID extends IdBase<ID,I>,I extends Serializable> extends BaseBean<ID,I>  {

	private static final long serialVersionUID = 8211224453324863096L;

	public HolderBaseBean() {
	}
}
