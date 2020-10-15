package MeiTuan;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-09-23
 */
public class VirusSpread {

    public static List<Integer> bfs(Map<Integer, Set<Integer>> map, Queue<Integer> queue, boolean[] visited, int t) {
        while (t >= 0 && !queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                visited[poll] = true;
                for (Integer next : map.get(poll)) {
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }
            t--;
        }
        return new ArrayList<>(queue);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> restSet = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(visited, true);
        for (int i = 0; i < n; i++) {
            map.put(i + 1, new HashSet<>());
            restSet.add(i + 1);
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            map.get(u).add(v);
            map.get(v).add(u);
        }
        int k = sc.nextInt(), t = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int v = sc.nextInt();
            set.add(v);
            visited[v] = false;
        }
        restSet.removeAll(set);
        Queue<Integer> queue = new ArrayDeque<>(restSet);
        List<Integer> bfs = bfs(map, queue, visited, t);
        if (bfs.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(bfs);
            System.out.println(bfs.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}