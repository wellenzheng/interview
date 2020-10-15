package JZOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-08-21
 */
public class FindContinuousSequence {

    public static List<List<Integer>> findContinuousSequence(int target) {
        List<List<Integer>> lists = new ArrayList<>();
        int left = 1, right = 2;
        while (left < right) {
            int sum = (left + right) * (right - left + 1) / 2;
            if (sum < target) {
                right++;
            } else if (sum > target) {
                left++;
            } else {
                List<Integer> list = IntStream.rangeClosed(left, right).boxed().collect(Collectors.toList());
                lists.add(list);
                left++;
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(findContinuousSequence(9));
    }
}
