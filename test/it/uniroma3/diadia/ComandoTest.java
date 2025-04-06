package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ComandoTest {

	@Before
	public void setUp() throws Exception{
		System.out.println("eseguo il set up");
	}
		
	@Test
	public void test1() {
		System.out.println("eseguo test 1");
		assertEquals(0,0);
		
	}

}
