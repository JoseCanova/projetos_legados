package org.nanotek.beans.entity;

import java.io.Serializable;

import org.nanotek.entities.MutableFrequencyEntity;
import org.nanotek.entities.MutableIsoCode2BEntity;
import org.nanotek.entities.MutableIsoCode2TEntity;
import org.nanotek.entities.MutableIsoCode3Entity;
import org.nanotek.entities.MutableLanguageIdEntity;

public interface MutableLanguageEntity <K extends Serializable> extends 					MutableLanguageIdEntity<Long>,
																							MutableIsoCode2TEntity<String>,
																							MutableIsoCode2BEntity<String>,
																							MutableFrequencyEntity<Long>,
																							MutableIsoCode3Entity<String> 
{
}
