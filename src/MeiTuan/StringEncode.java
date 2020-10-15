package MeiTuan;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-09-22
 */
public class StringEncode {

    /**
     * 最短编码即为霍夫曼编码，首先使用map记录每一个字符的个数，然后使用优先队列进行霍夫曼编码
     * @param s
     * @return
     */
    public static int encode(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.computeIfPresent(s.charAt(i), (k, v) -> v = v + 1);
            map.putIfAbsent(s.charAt(i), 1);
        }
        Queue<Integer> queue = new PriorityQueue<>();
        map.forEach((k, v) -> {
            queue.add(v);
        });
        while (queue.size() > 1) {
            Integer a = queue.poll();
            Integer b = queue.poll();
            res += (a + b);
            queue.add(a + b);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            System.out.println(encode(s));
        }
    }
}
