package JZOffer;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-08-24
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int index1 = 0, index2 = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i > 0 && nums[i] > nums[i - 1]) {
                index1 = i - 1;
                break;
            }
        }
        for (int i = index1; i < nums.length; i++) {
            if (nums[index1] > nums[i]) {
                index2 = i - 1;
                break;
            }
        }
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
        int left = index1 + 1, right = nums.length - 1;
        while (left < right) {
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
