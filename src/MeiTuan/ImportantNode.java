package MeiTuan;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-09-24
 */
public class ImportantNode {
    private static int count = 0;

    public static int bfs(List<List<Integer>> lists, int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[lists.size()];
        int count = 0;
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Integer next : lists.get(poll)) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        List<List<Integer>> positive = new ArrayList<>();
        List<List<Integer>> negative = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            positive.add(new ArrayList<>());
            negative.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            positive.get(u).add(v);
            negative.get(v).add(u);
        }
        for (int i = 1; i <= n; i++) {
            int s = bfs(positive, i);
            int t = bfs(negative, i);
            if (t > s) {
                count++;
            }
        }
        System.out.println(count);
    }
}
