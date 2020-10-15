package MeiTuan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-09-24
 */
public class ShareBike {
    private static int minCost = Integer.MAX_VALUE;

    public static void dfs(List<List<Node>> matrix, boolean[] hasBike, boolean[] visited, int curr, int n, int cost) {
        if (curr == n) {
            minCost = Math.min(minCost, cost);
        }
        visited[curr] = true;
        for (Node node : matrix.get(curr)) {
            if (!visited[node.key]) {
                if (hasBike[curr]) {
                    hasBike[node.key] = true;
                    cost += (node.value / 2);
                } else {
                    cost += node.value;
                }
                dfs(matrix, hasBike, visited, node.key, n, cost);
            }
        }
        visited[curr] = false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        List<List<Node>> matrix = new ArrayList<>();
        boolean[] hasBike = new boolean[n + 1];
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            matrix.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt(), v = scanner.nextInt(), w = scanner.nextInt();
            matrix.get(u).add(new Node(v, w));
            matrix.get(v).add(new Node(u, w));
        }
        int k = scanner.nextInt();
        for (int i = 0; i < k; i++) {
            hasBike[scanner.nextInt()] = true;
        }
        dfs(matrix, hasBike, visited, 1, n, 0);
        System.out.println(minCost == Integer.MAX_VALUE ? -1 : minCost);
    }

    private static class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
