package JZOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-08-19
 */
public class BigIntegerMultiply {

    public static String add(String num1, String num2) {
        if (num1 == null || num1.length() <= 0 || num2 == null || num2.length() <= 0) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 && j >= 0) {
            int temp = (num1.charAt(i) - '0') + (num2.charAt(j) - '0') + carry;
            carry = temp / 10;
            builder.append(temp % 10);
            i--;
            j--;
        }
        while (i >= 0) {
            int temp = (num1.charAt(i) - '0') + carry;
            carry = temp / 10;
            builder.append(temp % 10);
            i--;
        }
        while (j >= 0) {
            int temp = (num2.charAt(j) - '0') + carry;
            carry = temp / 10;
            builder.append(temp % 10);
            j--;
        }
        if (carry != 0) {
            builder.append(carry);
        }
        return builder.reverse().toString();
    }

    public static String multiply(String num1, String num2) {
        if (num1 == null || num1.length() <= 0 || num2 == null || num2.length() <= 0 ||
                num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        List<String> list = new ArrayList<>();
        for (int i = num1.length() - 1; i >= 0; i--) {
            StringBuilder builder = new StringBuilder();
            int carry = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int temp = (num2.charAt(j) - '0') * (num1.charAt(i) - '0') + carry;
                carry = temp / 10;
                builder.append(temp % 10);
            }
            if (carry != 0) {
                builder.append(carry);
            }
            builder.reverse();
            for (int j = i; j < num1.length() - 1; j++) {
                builder.append(0);
            }
            list.add(builder.toString());
        }
        String res = "0";
        for (String num : list) {
            res = add(num, res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }
}
