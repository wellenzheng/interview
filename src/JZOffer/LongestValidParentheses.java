package JZOffer;

import java.util.Stack;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-08-23
 */
public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        Stack<Integer> strings = new Stack<>();
        strings.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                strings.push(i);
            } else {
                strings.pop();
                if (!strings.empty()) {
                    max = Math.max(max, i - strings.peek());
                } else {
                    strings.push(i);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "()(())";
        System.out.println(longestValidParentheses(s));
    }
}
