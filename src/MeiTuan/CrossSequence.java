package MeiTuan;

import java.util.Scanner;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-09-24
 */
public class CrossSequence {
    public static int solve(int[] arr) {
        int startOne = 0;
        int startZero = 0;
        for (int value : arr) {
            if (value == 1 && startOne % 2 == 0) {
                startOne++;
            }
            if (value == 0 && startOne % 2 == 1) {
                startOne++;
            }
            if (value == 0 && startZero % 2 == 0) {
                startZero++;
            }
            if (value == 1 && startZero % 2 == 1) {
                startZero++;
            }
        }
        return Math.max(startOne, startZero);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solve(arr));
    }
}
