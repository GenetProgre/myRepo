package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import calculator.PayCalculator;

public class JuniorTest {

	private PayCalculator payCalculator;

	@Before
	public void setUp() {
		payCalculator = new PayCalculator();
	}

	@Test
	public void testJuniorPay() {
		assertEquals(20, payCalculator.payJunior(0, 2));
		assertEquals(40, payCalculator.payJunior(0, 4));
		assertEquals(60, payCalculator.payJunior(0, 6));
	}

	@Test
	public void testJuniorPayOverkill() {
		assertEquals(100, payCalculator.payJunior(0, 9));
		assertEquals(160, payCalculator.payJunior(0, 12));
		assertEquals(260, payCalculator.payJunior(0, 17));
		assertEquals(420, payCalculator.payJunior(0, 25));
	}

	@Test
	public void testPay() {
		assertEquals(20, payCalculator.pay(1, 2));
		assertEquals(60, payCalculator.pay(1, 6));
	}

}
