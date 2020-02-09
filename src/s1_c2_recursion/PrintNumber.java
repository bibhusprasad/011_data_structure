package s1_c2_recursion;

public class PrintNumber {

    public void foo(final int number) {
        if (number < 1) {
            return;
        } else {
            this.foo(number - 1);
        }
        System.out.println("Number is : " + number);
    }

    public static void main(final String[] args) {
        final PrintNumber printNumber = new PrintNumber();
        printNumber.foo(3);
    }
}
