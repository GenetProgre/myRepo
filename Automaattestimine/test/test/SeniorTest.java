package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import calculator.PayCalculator;

public class SeniorTest {

	private PayCalculator payCalculator;

	@Before
	public void setUp() {
		payCalculator = new PayCalculator();
	}

	@Test
	public void testJuniorPay() {
		assertEquals(30, payCalculator.paySenior(0, 2));
		assertEquals(60, payCalculator.paySenior(0, 4));
		assertEquals(90, payCalculator.paySenior(0, 6));
	}

	@Test
	public void testJuniorPayOverkill() {
		assertEquals(150, payCalculator.paySenior(0, 9));
		assertEquals(240, payCalculator.paySenior(0, 12));
		assertEquals(390, payCalculator.paySenior(0, 17));
		assertEquals(630, payCalculator.paySenior(0, 25));
	}

	@Test
	public void testPay() {
		assertEquals(30, payCalculator.pay(2, 2));
		assertEquals(90, payCalculator.pay(2, 6));
	}

}
