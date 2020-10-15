package JZOffer;

/**
 * @author zhengweijun
 * Created on 2020-07-19
 */
public class Fib {

    public static int fib(int n) {
        int first = 0, second = 1;
        while (n > 0) {
            long next = (long) ((first + second) % (1e9 + 7));
            first = second;
            second = (int) next;
            n--;
        }
        return (int) (first % (1e9 + 7));
    }

    public static void main(String[] args) {
        System.out.println(fib(1));
    }
}
