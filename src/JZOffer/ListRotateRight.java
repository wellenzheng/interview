package JZOffer;

import java.util.PriorityQueue;

import utils.ListNode;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-08-19
 */
public class ListRotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        int length = 0;
        while (curr != null) {
            curr = curr.next;
            length++;
        }
        k = k % length;
        if (k == 0) {
            return head;
        }
        ListNode node1 = head;
        ListNode node2 = head;
        while (k > 0) {
            node2 = node2.next;
            k--;
        }
        while (node2.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        ListNode res = node1.next;
        node2.next = head;
        node1.next = null;
        return res;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < 10; i++) {
            queue.add(i);
        }
        System.out.println(queue.peek());
    }
}
