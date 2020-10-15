package JZOffer;

/**
 * @author zhengweijun
 * Created on 2020-07-19
 */

public class FindRepeatNumber {

    public static int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                int m = nums[i];
                if (nums[m] == m) {
                    return m;
                } else {
                    nums[i] = nums[m];
                    nums[m] = m;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 3, 4, 5, 4, 6, 4};
        System.out.println(findRepeatNumber(nums));
    }
}
