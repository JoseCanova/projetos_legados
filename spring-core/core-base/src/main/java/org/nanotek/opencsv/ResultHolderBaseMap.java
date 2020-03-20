package org.nanotek.opencsv;

import java.util.Optional;
import java.util.Set;

import org.nanotek.Base;
import org.nanotek.BaseException;
import org.nanotek.IdBase;
import org.nanotek.beans.csv.AreaBean;
import org.nanotek.beans.entity.Area;

/**
 * this bean will god to spring. it holds the reference of the configuration of the beans 
 * to load the CSV line.
 *
 * @param <K>
 * @param <ID>
 * @param <I>
 */
public class ResultHolderBaseMap<I extends IdBase<I,?>, ID extends IdBase<?,?>, K extends IdBase<K,ID>> 
extends HolderBaseMap<K, ID> implements ColumnMapHolder<I> {

	private static final long serialVersionUID = -1565015302783229070L;

	private String[] columnMapping;

	private Class<I> clazz;
	

	public ResultHolderBaseMap(K immutable) {
		super(immutable);
	}
	
	public ResultHolderBaseMap(K immutable,Class<I> clazz) {
		super(immutable);
		this.clazz = clazz;
	}

	public ResultHolderBaseMap() {
		super(null);
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		super.afterPropertiesSet();
		verifyConfiguration();
	}
	
	@Override
	public Optional<I> verifyConfiguration() {
		Optional<Set<String>> x = size() == 0 ? Optional.empty():Optional.of(keySet());
		x.ifPresent(s -> {
			columnMapping  = new String[size()];
			s.stream().forEach(k ->{
				Integer position = get(k);
				assert (position !=null && position <= columnMapping.length);
				columnMapping[get(k)] = k;
			});
		});
		return Base.newInstance(Optional.ofNullable(clazz).orElseThrow(BaseException::new));
	}

	public Optional<String[]> getColumnMapping() {
		return Optional.ofNullable(columnMapping);
	}

	public static void main(String[] args) throws Exception {
		ResultHolderBaseMap map = new ResultHolderBaseMap(new AreaBean(),Area.class);
		map.afterPropertiesSet();
	}
	
}
