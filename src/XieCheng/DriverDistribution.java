package XieCheng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-10-13
 */
public class DriverDistribution {

    public static int n = 0;
    public static List<Integer> A = new ArrayList<>();
    public static List<Integer> B = new ArrayList<>();
    public static int sumA = 0, sumB = 0;

    public static int maxSum = 0;

    //暴力穷举
    public static void pickN(int count, int index, int suma, int sumb) {
        if (count == 0) {
            if (suma + sumB - sumb > maxSum) {
                maxSum = suma + sumB - sumb;
            }
            System.out.printf("suma: %d, sumb: %d \n", suma, sumB - sumb);
        } else if (count > 0) {
            for (int i = index; i < A.size(); i++) {
                count--;
                pickN(count, i + 1, suma + A.get(i), sumb + B.get(i));
                count++;
            }
        }
    }

    /**
     * 方法二，贪心
     *
     * 首先假定所有人都去B市，然后再从中选出n个人前往A市，那么这时需要付出的额外费用为priceA-priceB
     *
     * 那么总的费用为sumB + /sumN(priceA - priceB)
     *
     * 那么要使/sumN(priceA - priceB)最小，即费用最小
     */

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> (o1[0] - o1[1] - (o2[0] - o2[1])));
        int sum = 0;
        int n = costs.length / 2;
        for (int i = 0; i < n; i++) {
            sum += costs[i][0] + costs[i + n][1];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.equals("#")) {
                break;
            } else {
                String[] split = line.split(" ");
                try {
                    int a = Integer.parseInt(split[0]);
                    int b = Integer.parseInt(split[1]);
                    A.add(a);
                    B.add(b);
                    sumA += a;
                    sumB += b;
                    n++;
                } catch (NumberFormatException e) {
                    System.out.println("error");
                    return;
                }
            }
        }
        pickN(n / 2, 0, 0, 0);
        System.out.println(maxSum);
    }
}
