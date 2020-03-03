package org.nanotek.service.jpa;

import java.io.Serializable;

import org.nanotek.Base;
import org.nanotek.service.BaseService;

@SuppressWarnings("serial")
public abstract class BasePersistenceService<O extends Base, K extends Serializable> implements BaseService<O,K>{
}
