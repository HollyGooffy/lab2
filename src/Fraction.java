public class Fraction {
	private int numerator;
	private int denominator;

	public Fraction(int numerator, int denominator) {
		if (denominator == 0) {
			throw new IllegalArgumentException("Denominator cannot be zero.");
		}
		this.numerator = numerator;
		this.denominator = denominator;
	}

	Fraction(int numerator) {
		this(numerator, 1);
	}

	// Greatest Common Divisor
	private int gcd(int a, int b) {
		while (a != b) {
			if (a > b) {
				a -= b;
			} else {
				b -= a;
			}
		}
		return a;
	}

	private void reduce() {
		int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
		numerator /= gcd;
		denominator /= gcd;

		if (denominator < 0) {
			numerator = -numerator;
			denominator = -denominator;
		}
	}

	public Fraction add(Fraction fraction) {
		if (fraction.numerator == 0) {
			return new Fraction(this.numerator, this.denominator);
		} else {
			int newNumerator = this.numerator * fraction.denominator + fraction.numerator * this.denominator;
			int newDenominator = this.denominator * fraction.denominator;
			Fraction result = new Fraction(newNumerator, newDenominator);
			result.reduce();
			return result;
		}
	}

	public Fraction subtract(Fraction fraction) {
		if (fraction.numerator == 0) {
			return new Fraction(this.numerator, this.denominator);
		} else {
			int newNumerator = this.numerator * fraction.denominator - fraction.numerator * this.denominator;
			int newDenominator = this.denominator * fraction.denominator;
			Fraction result = new Fraction(newNumerator, newDenominator);
			result.reduce();
			return result;
		}
	}

	public Fraction multiply(Fraction fraction) {
		if (fraction.numerator == 0) {
			return new Fraction(0, 1);
		} else {
			int newNumerator = this.numerator * fraction.numerator;
			int newDenominator = this.denominator * fraction.denominator;
			Fraction result = new Fraction(newNumerator, newDenominator);
			result.reduce();
			return result;
		}
	}

	public Fraction divide(Fraction fraction) {
		if (fraction.numerator == 0) {
			throw new ArithmeticException("Division by zero");
		} else {
			int newNumerator = this.numerator * fraction.denominator;
			int newDenominator = this.denominator * fraction.numerator;
			Fraction result = new Fraction(newNumerator, newDenominator);
			result.reduce();
			return result;
		}
	}

	public String toString() {
		return numerator + "/" + denominator;
	}
}