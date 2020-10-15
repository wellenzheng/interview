package JZOffer;

import java.util.Stack;

/**
 * @author zhengweijun
 * Created on 2020-07-20
 */
class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (!minStack.isEmpty()) {
            if (minStack.peek() <= x) {
                minStack.push(minStack.peek());
            } else {
                minStack.push(x);
            }
        } else {
            minStack.push(x);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}

/**
 * Your JZOffer.MinStack object will be instantiated and called as such:
 * JZOffer.MinStack obj = new JZOffer.MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
