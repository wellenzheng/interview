package MeiTuan;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-09-22
 */
public class MaxInnerRec {

    /**
     * 暴力算法
     * @param A
     * @param n
     * @return
     */
    public int countArea(int[] A, int n) {
        // write code here
        int max = 0;
        for (int i = 0; i < n; i++) {
            int height = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                height = Math.min(height, A[j]);
                int area = height * (j - i + 1);
                max = Math.max(max, area);
            }
        }
        return max;
    }
}
