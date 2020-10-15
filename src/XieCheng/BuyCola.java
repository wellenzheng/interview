package XieCheng;

import java.util.Scanner;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-10-13
 */
public class BuyCola {

    public static int m, price;
    public static int[] coins = {10, 50, 100};
    public static int[] nums = new int[3];



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        for (int i = 0; i < 3; i++) {
            nums[i] = scanner.nextInt();
        }
        price = scanner.nextInt();
    }
}
