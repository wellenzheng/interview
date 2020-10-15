package MeiTuan;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-09-22
 */
public class LongestDistance {
    /**
     * 贪心算法，股票问题
     * @param A
     * @param n
     * @return
     */
    public int getDis(int[] A, int n) {
        // write code here
        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i] - min);
        }
        return max;
    }
}
