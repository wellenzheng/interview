package JZOffer;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-08-01
 */
public class MissingNumber {

    public static int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] != mid) {
                right = mid - 1;
                if (mid == 0 || nums[mid - 1] == mid - 1) {
                    return mid;
                }
            } else {
                left = mid + 1;
            }
        }
        if (left == nums.length) {
            return nums.length;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 5, 6, 7, 8};
        System.out.println(missingNumber(nums));
    }
}
