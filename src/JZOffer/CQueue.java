package JZOffer;

import java.util.Stack;

/**
 * @author zhengweijun
 * Created on 2020-07-19
 */
public class CQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack1.size() <= 0) {
            return -1;
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int head = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return head;
    }
}
