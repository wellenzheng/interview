package MeiTuan;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-09-22
 */

public class Visit {
    int count = 0;

    public static void dfs(int[][] map, int n, int m, int i, int j, boolean[][] visited, int[][] dp) {
        visited[i][j] = true;
        if (map[i][j] == -1) {
            dp[i][j] = 0;
        } else if (map[i][j] != 1 && dp[i][j] == 0) {
            int up = i == 0 ? 0 : dp[i - 1][j];
            int down = i == n - 1 ? 0 : dp[i + 1][j];
            int left = j == 0 ? 0 : dp[i][j - 1];
            int right = j == m - 1 ? 0 : dp[i][j + 1];
            dp[i][j] = up + down + left + right;
        }

        if (i > 0 && !visited[i - 1][j] && map[i - 1][j] != -1) {
            dfs(map, n, m, i - 1, j, visited, dp);
        }
        if (i + 1 < n && !visited[i + 1][j] && map[i + 1][j] != -1) {
            dfs(map, n, m, i + 1, j, visited, dp);
        }
        if (j > 0 && !visited[i][j - 1] && map[i][j - 1] != -1) {
            dfs(map, n, m, i, j - 1, visited, dp);
        }
        if (j + 1 < m && !visited[i][j + 1] && map[i][j + 1] != -1) {
            dfs(map, n, m, i, j + 1, visited, dp);
        }
    }

    public static int countPath(int[][] map, int n, int m) {
        // write code here
        int x1 = 0, y1 = 0;
        int x2 = 0, y2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    x1 = i;
                    y1 = j;
                    break;
                }
                if (map[i][j] == 2) {
                    x2 = i;
                    y2 = j;
                }
            }
        }
        int[][] dp = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        dp[x1][y1] = 1;
        dfs(map, n, m, x1, y1, visited, dp);
        return dp[x2][y2];
    }

    public static void main(String[] args) {
        int[][] map = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 2}};
        int n = 7, m = 5;
        System.out.println(countPath(map, n, m));
    }
}
