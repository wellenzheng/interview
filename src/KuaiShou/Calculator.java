package KuaiShou;

import java.util.Stack;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-09-23
 */
public class Calculator {

    public static String calculate(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = 10 * num + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                stack.push(String.valueOf(num));
            } else if (s.charAt(i) == '(' ||
                    s.charAt(i) == '*' || s.charAt(i) == '/') {
                stack.push(String.valueOf(s.charAt(i)));
            } else if (s.charAt(i) == ')') {
                int n1 = Integer.parseInt(stack.pop());
                String op = stack.pop();
                int n2 = Integer.parseInt(stack.pop());
                stack.pop();
                stack.push(String.valueOf(cal(n2, n1, op)));
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                int n1 = Integer.parseInt(stack.pop());
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    String op = stack.pop();
                    int n2 = Integer.parseInt(stack.pop());
                    n1 = cal(n2, n1, op);
                }
                stack.push(String.valueOf(n1));
                stack.push(String.valueOf(s.charAt(i)));
            }
        }
        while (!stack.isEmpty() && stack.size() != 1) {
            int n1 = Integer.parseInt(stack.pop());
            String op = stack.pop();
            int n2 = Integer.parseInt(stack.pop());
            stack.push(String.valueOf(cal(n2, n1, op)));
        }
        return stack.pop();
    }

    public static int cal(int n1, int n2, String op) {
        switch (op) {
            case "+":
                return n1 + n2;
            case "-":
                return n1 - n2;
            case "*":
                return n1 * n2;
            case "/":
                return n1 / n2;
            default:
                return 0;
        }
    }
}
