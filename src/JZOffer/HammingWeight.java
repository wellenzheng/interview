package JZOffer;

/**
 * @author zhengweijun
 * Created on 2020-07-20
 */
public class HammingWeight {

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(2));
    }
}
