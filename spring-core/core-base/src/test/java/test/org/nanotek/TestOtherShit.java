package test.org.nanotek;

import java.util.*;

public class TestOtherShit {

	public TestOtherShit() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Integer var = null; 
		Object result = Optional.ofNullable(var).map(t -> String.valueOf(t)).orElse("");
		System.out.println(result);
	}

}
