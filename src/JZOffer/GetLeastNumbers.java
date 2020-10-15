package JZOffer;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-08-21
 */
public class GetLeastNumbers {

    public static int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for (int n : arr) {
            if (queue.size() < k) {
                queue.add(n);
            } else if (!queue.isEmpty() && n < queue.peek()) {
                queue.poll();
                queue.add(n);
            }
        }
        return queue.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {1, 23, 5, 5, 634, 37, 7, 23, 45, 7, 234, 5, 123};
        System.out.println(Arrays.toString(getLeastNumbers(arr, 4)));
    }
}
