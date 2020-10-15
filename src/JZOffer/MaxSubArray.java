package JZOffer;

/**
 * @author zhengweijun
 * Created on 2020-07-20
 */
public class MaxSubArray {

    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = Integer.MIN_VALUE;
        for (int num : nums) {
            if (sum <= 0) {
                sum = num;
            } else {
                sum += num;
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

}
