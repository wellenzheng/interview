package JZOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-08-20
 */
public class SingleNumbers {

    public static int[] singleNumbers(int[] nums) {
        if (nums.length <= 0) {
            return nums;
        }
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum ^= nums[i];
        }
        int oneBit = findOneBit(sum);

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int num : nums) {
            int n = num >> (oneBit - 1) & 1;
            if (n == 1) {
                list1.add(num);
            } else {
                list2.add(num);
            }
        }

        int first = list1.isEmpty() ? -1 : list1.get(0);
        int second = list2.isEmpty() ? -1 : list2.get(0);

        if (first != -1) {
            for (int i = 1; i < list1.size(); i++) {
                first ^= list1.get(i);
            }
        }

        if (second != -1) {
            for (int i = 1; i < list2.size(); i++) {
                second ^= list2.get(i);
            }
        }

        return new int[] {first, second};
    }

    public static int findOneBit(int sum) {
        int count = 1;
        int bit = sum & 1;
        while (bit == 0) {
            sum >>= 1;
            bit = sum & 1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 10, 4, 1, 4, 3, 3};
        System.out.println(Arrays.toString(singleNumbers(nums)));
        //        System.out.println(10 & 8);
    }

}
