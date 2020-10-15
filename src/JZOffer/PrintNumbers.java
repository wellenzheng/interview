package JZOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author zhengweijun
 * Created on 2020-07-20
 */
public class PrintNumbers {

    public static int[] printNumbers(int n) {
        String s = calculate(n);
        String num = "1";
        List<Integer> list = new ArrayList<>();
        while (!num.equals(s)) {
            list.add(Integer.parseInt(num));
            num = incr(num);
        }
        return list.stream().filter(Objects::nonNull).mapToInt(t -> t).toArray();
    }

    public static String calculate(int n) {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(1);
        for (int i = 0; i < n; i++) {
            stringBuilder.append(0);
        }
        return stringBuilder.toString();
    }

    public static String incr(String s) {
        StringBuilder stringBuilder = new StringBuilder("");
        int carry = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            int num = c - '0' + carry;
            if (num >= 10) {
                num = num % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            stringBuilder.append(num);
        }
        if (carry != 0) {
            stringBuilder.append(carry);
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNumbers(1)));
    }
}
