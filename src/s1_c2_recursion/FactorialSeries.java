package s1_c2_recursion;

public class FactorialSeries {

    public int findFactorial(int number){
        if(number != 0){
            return number * findFactorial(number-1);
        }
        return 1;
    }

    public static void main(String[] args) {
        FactorialSeries factorialSeries = new FactorialSeries();
        int num = factorialSeries.findFactorial(5);
        System.out.println(num);
    }
}
