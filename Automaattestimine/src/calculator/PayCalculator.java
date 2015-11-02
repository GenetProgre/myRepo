package calculator;

public class PayCalculator {
	
	public static final int JUNIOR = 1;
	public static final int SENIOR = 2;
	public static final int SPECIALIST = 3;
	
	public int payJunior(int sum, final int hours) {
		if (hours > 8) {
			sum = 10 * (hours - 8) * 2;
			sum += 10 * 8;
			return sum;
		} else {
			sum += 10 * hours;
			return sum;
		}
	}

	public int paySenior(int sum, final int hours) {
		if (hours > 8) {
			sum = 15 * (hours - 8) * 2;
			sum += 15 * 8;
			return sum;
		} else {
			sum += 15 * hours;
			return sum;
		}
	}

	public int paySpecialist(int sum, final int hours) {
		if (hours > 9) {
			sum = 22 * (hours - 9) * 3;
			sum += 22 * 9;
			return sum;
		} else {
			sum += 22 * hours;
			return sum;
		}
	}

	public int payBonus(final int type, int sum) {
		if (type == JUNIOR) {
			sum = 10;
		}
		if (type == SENIOR) {
			sum = 20;
		}
		if (type == SPECIALIST) {
			sum = 30;
		}
		return sum;
	}

	public int pay(final int type, final int hours) {
		int sum = 0;
		if (type == JUNIOR) {
			sum = payJunior(sum, hours);
		}
		if (type == SENIOR) {
			sum = paySenior(sum, hours);
		}
		if (type == SPECIALIST) {
			sum = paySpecialist(sum, hours);
		}
		if (hours > 20) {
			sum += payBonus(type, sum);
		}
		return sum;
	}
}