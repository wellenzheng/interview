package JZOffer;

import java.util.Arrays;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-08-21
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        if (nums.length <= 0) {
            return nums;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[] {nums[left], nums[right]};
            }
        }
        return left == right ? null : new int[] {nums[left], nums[right]};
    }

    public static void main(String[] args) {
        int[] nums = {10, 26, 30, 31, 47, 60};
        System.out.println(Arrays.toString(twoSum(nums, 40)));
    }
}
