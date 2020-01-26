package s1.c2.recursion;

public class FibonacciSeries {
    public int findFibonacci(int number){
        if(number < 1)
            return 0;
        else if(number == 1 || number == 2)
            return number-1;
        else
            return findFibonacci(number-1)+findFibonacci(number-2);
    }
    public static void main(String[] args) {
        FibonacciSeries fibonacciSeries = new FibonacciSeries();
        int result = fibonacciSeries.findFibonacci(6);
        System.out.println(result);
    }
}
