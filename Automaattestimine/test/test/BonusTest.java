package test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import calculator.PayCalculator;

public class BonusTest {
	
	private PayCalculator payCalculator;
	
	@Before
	public void setUp() {
		payCalculator = new PayCalculator();
	}
	
	@Test
	public void juniorBonus() {
		assertEquals(430, payCalculator.pay(1, 25));
		assertEquals(470, payCalculator.pay(1, 27));
	}
	
	
	@Test
	public void seniorBonus() {
		assertEquals(650, payCalculator.pay(2, 25));
		assertEquals(710, payCalculator.pay(2, 27));
	}
	
	@Test
	public void specialistBonus() {
		assertEquals(1284, payCalculator.pay(3, 25));
		assertEquals(1416, payCalculator.pay(3, 27));
	}
}