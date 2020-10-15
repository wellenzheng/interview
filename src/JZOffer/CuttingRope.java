package JZOffer;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-08-23
 */
public class CuttingRope {

    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int numOf3 = n / 3;
        int rest = n % 3;
        if (rest == 1) {
            numOf3--;
            rest += 3;
        }
        int numOf2 = rest / 2;
        return (int) (Math.pow(3, numOf3) * Math.pow(2, numOf2));
    }

    public static void main(String[] args) {

    }

}
