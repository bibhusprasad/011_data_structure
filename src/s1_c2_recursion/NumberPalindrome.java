package s1_c2_recursion;

public class NumberPalindrome {

    public int checkPalindrome(final int number, int temp) {
        if (number == 0) {
            return temp;
        }
        temp = (temp * 10) + (number % 10);
        return this.checkPalindrome(number / 10, temp);
    }

    public static void main(final String[] args) {
        final NumberPalindrome numberPalindrome = new NumberPalindrome();
        final int number = 1221;
        final int temp = numberPalindrome.checkPalindrome(1221, 0);
        if (number == temp) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
