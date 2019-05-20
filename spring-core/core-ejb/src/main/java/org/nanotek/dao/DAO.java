package org.nanotek.dao;

import java.io.Serializable;
import java.util.List;

import org.nanotek.Base;

public interface DAO <T extends Base<?>> extends Serializable{
        
         List<T> loadAll(); 
         T find (T sample);
         <I extends Serializable> T find (I i);
         <I extends Serializable> T find (Class<T> t , I i);
         void persist(T object);
         void update (T object); 
         void delete (T object);
         List<T> listRecords (Integer firstResult , Integer maxResults);
}
