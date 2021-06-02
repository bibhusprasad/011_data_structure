package s1_c2_recursion;

public class FactorialSeries {

	public int findFactorial(final int number) {
		if (number != 0) {
			return number * this.findFactorial(number - 1);
		}
		return 1;
	}

	public static void main(final String[] args) {
		final FactorialSeries factorialSeries = new FactorialSeries();
		final int num = factorialSeries.findFactorial(5);
		System.out.println(num);
	}
}
