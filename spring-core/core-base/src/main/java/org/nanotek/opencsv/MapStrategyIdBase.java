package org.nanotek.opencsv;

import java.util.Optional;

import org.nanotek.IdBase;
import org.nanotek.Result;
import org.nanotek.WrappedEntityBase;
import org.nanotek.beans.csv.ArtistBean;
import org.nanotek.beans.csv.BaseBean;
import org.nanotek.beans.entity.Area;
import org.nanotek.beans.entity.Artist;


public class MapStrategyIdBase
<K extends WrappedEntityBase<J>, 
ID extends IdBase<ID,?> , 
J extends BaseBean<ID> , 
B extends ResultHolderBaseMap<J,K>> implements 
MapStrategy <K, 
ID , 
J  , 
B >{
	
	Optional<J> optionalIdBaseMap;
	
	Optional<ID> optionalWrapperBean;
	
	Optional<ID> identityClass;
	
	Optional<B> resultBean;
	
	

	
//	static <KK extends K,  
//				K extends WrappedBaseClass<KK,IID> , 
//				IID extends ID,
//				ID extends IdBase<IID , ?>,
//				JJ extends J, 
//				J extends IdBase<JJ,ID>,
//				BB extends B, 
//				B extends ResultHolderBaseMap<IID,IID,KK>>
//				MapStrategyIdBase<KK,IID,JJ,BB> withClasses(Class<KK> k, Class<IID> i , Class<JJ> j , Class<BB> b) {
//		
//		
//		return new MapStrategyIdBase(k , i , j , b);
//		
//	}

	
	public static void main(String[] args) {
		MapStrategyIdBase b = new MapStrategyIdBase(WrappedBaseClass.class, Artist.class ,ArtistBean.class , ResultHolderBaseMap.class);
//		
		b.createWrappedBaseClass(ArtistBean.class, Artist.class);
	}

	public MapStrategyIdBase(Class<K> k, Class<ID> i , Class<J> j , Class<B> b) {
		
		
		
		
		System.out.println(this.toString());
	}

	@Override
	public Optional<Result<ID, ?>> findProperty(String property) {
		// TODO Auto-generated method stub
		return null;
	}


}
