package test.org.nanotek;

import org.nanotek.UUIDNameBase;

public class TestUUIDBaseShit {

	public TestUUIDBaseShit() {
	}

	public static void main(String[] args) {
		org.nanotek.Base.newInstance(UUIDNameBase.class).ifPresent(u -> {
			u.withName("jose canova"); u.withUUID(); System.out.println(u.toString());
		});
	}

}
