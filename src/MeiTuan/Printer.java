package MeiTuan;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-09-22
 */
public class Printer {
    /**
     * 二维数组对角线打印
     */
    public int[] arrayPrint(int[][] arr, int n) {
        // write code here
        int[] res = new int[n * n];
        int i = 0, j = n - 1, k = 0;
        int row = 0, col = n - 1;
        while (k < n * n) {
            res[k++] = arr[i++][j++];
            if (i >= n) {
                j = 0;
                i = ++row;
            } else if (j >= n) {
                i = 0;
                j = --col;
            }
        }
        return res;
    }
}
