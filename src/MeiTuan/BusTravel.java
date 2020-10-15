package MeiTuan;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-09-23
 */
public class BusTravel {

    public static int bfs(ArrayList<Integer>[] graph, int curr, int n, int m) {
        int[] dist = new int[n + m + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        dist[curr] = 1;
        queue.add(curr);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Integer next : graph[poll]) {
                if (dist[next] == 0) {
                    dist[next] = dist[poll] + 1;
                    queue.add(next);
                }
            }
        }
        return dist[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        ArrayList<Integer>[] graph = new ArrayList[n + m + 1];
        for (int i = 1; i <= m; i++) {
            graph[n + i] = new ArrayList<>();
            int t = sc.nextInt();
            for (int j = 0; j < t; j++) {
                int station = sc.nextInt();
                if (graph[station] == null) {
                    graph[station] = new ArrayList<>();
                }
                graph[n + i].add(station);
                graph[station].add(n + i);
            }
        }
        int bfs = bfs(graph, 1, n, m);
        System.out.println(bfs == 0 ? -1 : bfs / 2);
    }
}
