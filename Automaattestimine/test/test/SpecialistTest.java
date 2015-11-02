package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import calculator.PayCalculator;

public class SpecialistTest {
	
	private PayCalculator payCalculator;
	
	@Before
	public void setUp() {
		payCalculator = new PayCalculator();
	}
	
	@Test
	public void testJuniorPay() {
		assertEquals(44, payCalculator.paySpecialist(0, 2));
		assertEquals(88, payCalculator.paySpecialist(0, 4));
		assertEquals(132, payCalculator.paySpecialist(0, 6));
	}
	
	@Test
	public void testJuniorPayOverkill() {
		assertEquals(198, payCalculator.paySpecialist(0, 9));
		assertEquals(396, payCalculator.paySpecialist(0, 12));
		assertEquals(726, payCalculator.paySpecialist(0, 17));
	}
	
	@Test
	public void testPay() {
		assertEquals(44, payCalculator.pay(3, 2));
		assertEquals(66, payCalculator.pay(3, 3));
		assertEquals(132, payCalculator.pay(3, 6));
	}

}
