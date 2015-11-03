package calculator;

public class PayCalculator {

	public static final int JUNIOR = 1;
	public static final int SENIOR = 2;
	public static final int SPECIALIST = 3;
	public static final int JUNIOR_CONSTANT = 10;
	public static final int SENIOR_CONSTANT = 15;
	public static final int SPECIALIST_CONSTANT = 22;
	public static final int JUNIOR_AND_SENIOR_LIMIT = 8;
	public static final int SPECIALIST_LIMIT = 9;
	public static final int JUNIOR_BONUS = 10;
	public static final int SENIOR_BONUS = 20;
	public static final int SPECIALIST_BONUS = 30;

	public int payJunior(int sum, final int hours) {
		if (hours > JUNIOR_AND_SENIOR_LIMIT) {
			sum = JUNIOR_CONSTANT * (hours - JUNIOR_AND_SENIOR_LIMIT) * 2;
			sum += JUNIOR_CONSTANT * JUNIOR_AND_SENIOR_LIMIT;
			return sum;
		} else {
			sum += JUNIOR_CONSTANT * hours;
			return sum;
		}
	}

	public int paySenior(int sum, final int hours) {
		if (hours > JUNIOR_AND_SENIOR_LIMIT) {
			sum = SENIOR_CONSTANT * (hours - JUNIOR_AND_SENIOR_LIMIT) * 2;
			sum += SENIOR_CONSTANT * JUNIOR_AND_SENIOR_LIMIT;
			return sum;
		} else {
			sum += SENIOR_CONSTANT * hours;
			return sum;
		}
	}

	public int paySpecialist(int sum, final int hours) {
		if (hours > SPECIALIST_LIMIT) {
			sum = SPECIALIST_CONSTANT * (hours - SPECIALIST_LIMIT) * 3;
			sum += SPECIALIST_CONSTANT * SPECIALIST_LIMIT;
			return sum;
		} else {
			sum += SPECIALIST_CONSTANT * hours;
			return sum;
		}
	}

	public int payBonus(final int type, int sum) {
		if (type == JUNIOR) {
			sum = JUNIOR_BONUS;
		}
		if (type == SENIOR) {
			sum = SENIOR_BONUS;
		}
		if (type == SPECIALIST) {
			sum = SPECIALIST_BONUS;
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