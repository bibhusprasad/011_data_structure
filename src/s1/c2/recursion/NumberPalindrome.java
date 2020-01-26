package s1.c2.recursion;

public class NumberPalindrome {

    public int checkPalindrome(int number, int temp){
        if(number == 0)
            return temp;
        temp = (temp * 10) + (number % 10);
        return checkPalindrome(number/10, temp);

    }

    public static void main(String[] args) {
        NumberPalindrome numberPalindrome = new NumberPalindrome();
        int  number = 1221;
        int temp = numberPalindrome.checkPalindrome(1221, 0);
        if(number == temp){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
