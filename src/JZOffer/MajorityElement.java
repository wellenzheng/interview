package JZOffer;

/**
 * @author zhengweijun
 * Created on 2020-07-20
 */
public class MajorityElement {

    public static int majorityElement(int[] nums) {
        int index = help(nums, 0, nums.length - 1);
        return nums[index];
    }

    public static int help(int[] nums, int left, int right) {
        int index = partition(nums, left, right);
        if (index > nums.length / 2) {
            return help(nums, left, index - 1);
        } else if (index < nums.length / 2) {
            return help(nums, index + 1, right);
        }
        return index;
    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElement(nums));
    }
}
