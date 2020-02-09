package s1_c2_recursion;

public class FibonacciSeries {
    public int findFibonacci(final int number) {
        if (number < 1) {
            return 0;
        } else if (number == 1 || number == 2) {
            return number - 1;
        } else {
            return this.findFibonacci(number - 1) + this.findFibonacci(number - 2);
        }
    }

    public static void main(final String[] args) {
        final FibonacciSeries fibonacciSeries = new FibonacciSeries();
        final int result = fibonacciSeries.findFibonacci(6);
        System.out.println(result);
    }
}
