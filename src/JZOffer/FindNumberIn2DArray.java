package JZOffer;

/**
 * @author zhengweijun
 * Created on 2020-07-19
 */
public class FindNumberIn2DArray {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length <= 0) {
            return false;
        }
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (target > matrix[i][j]) {
                i++;
            } else if (target < matrix[i][j]) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{5}};
        System.out.println(findNumberIn2DArray(matrix, 5));
    }

}
