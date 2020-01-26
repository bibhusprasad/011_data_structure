package s1.c2.recursion;

public class PrintNumber {

    public void foo(int number){
        if(number < 1){
            return;
        }else{
            foo(number - 1);
        }
        System.out.println("Number is : " + number);
    }

    public static void main(String[] args) {
        PrintNumber printNumber = new PrintNumber();
        printNumber.foo(3);
    }
}
