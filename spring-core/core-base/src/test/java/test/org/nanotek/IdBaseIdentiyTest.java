package test.org.nanotek;

import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.nanotek.BaseEntity;
import org.nanotek.Id;
import org.nanotek.IdBase;
import org.nanotek.WrappedEntityBase;
import org.nanotek.beans.csv.AreaBean;
import org.nanotek.beans.csv.BaseBean;
import org.nanotek.beans.entity.Area;
import org.nanotek.beans.entity.SequenceLongBase;
import org.nanotek.opencsv.WrappedBaseClass;

public class IdBaseIdentiyTest {

	public void setUp() throws Exception {
	}

	public void test() {
	}
	
	public void testSequenceLongBaseId() {
		SequenceLongBase seq = new SequenceLongBase(); 
		Optional<SequenceLongBase> opt = BaseEntity.newBaseEntityInstance(SequenceLongBase.class , Long.TYPE);
		System.out.println(opt);
		Id<?> t = opt.get().asId();
		Optional<AreaBean> bb = BaseBean.newBaseBeanInstance(AreaBean.class, Arrays.array(IdBase.prepareBeanInstance(Area.class)),Area.class);
		Optional<?> optw = WrappedEntityBase.newBaseBeanInstance(bb.get());
		print(t.getId());
	}

	private void print(Object o) {
		System.out.println(o);
	}
	

	public static void main(String[] args) { 
		IdBaseIdentiyTest t = new IdBaseIdentiyTest();
		t.testSequenceLongBaseId();
		
	}
	
}
