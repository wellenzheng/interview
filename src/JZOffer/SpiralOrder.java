package JZOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author zhengweijun
 * Created on 2020-07-20
 */
public class SpiralOrder {

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length <= 0 || matrix[0].length <= 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int col = matrix[0].length;
        int row = matrix.length;
        int start = 0;
        while (col > start * 2 && row > start * 2) {
            help(list, matrix, matrix[0].length, matrix.length, start);
            start++;
        }
        return list.stream().filter(Objects::nonNull).mapToInt(n -> n).toArray();
    }

    public static void help(List<Integer> list, int[][] matrix, int col, int row, int start) {
        int endx = col - 1 - start;
        int endy = row - 1 - start;
        for (int i = start; i <= endx; i++) {
            list.add(matrix[start][i]);
        }
        if (start < endy) {
            for (int i = start + 1; i <= endy; i++) {
                list.add(matrix[i][endx]);
            }
        }
        if (start < endx && start < endy) {
            for (int i = endx - 1; i >= start; i--) {
                list.add(matrix[endy][i]);
            }
        }
        if (start < endx && start < endy - 1) {
            for (int i = endy - 1; i >= start + 1; i--) {
                list.add(matrix[i][start]);
            }
        }
    }

}
