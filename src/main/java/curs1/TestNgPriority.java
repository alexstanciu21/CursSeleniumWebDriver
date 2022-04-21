package curs1;

import org.testng.annotations.Test;

public class TestNgPriority {
	
	@Test(priority=0)
	public void one() {
		System.out.println("First");
	}
	
	@Test(priority=1)
	public void two() {
		System.out.println("Second");
	}
	
	@Test(priority=2)
	public void third() {
		System.out.println("Third");
	}
	
	@Test
	public void fourth() {
		System.out.println("Fourth");
	}
	
	@Test
	public void fifth() {
		System.out.println("Fifth");
	}

}
