package JZOffer;

import utils.ListNode;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-08-21
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode newHead = pre, tail = pre;
        while (true) {
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return newHead.next;
                }
            }
            ListNode next = tail.next, con = pre.next, p = pre, curr = pre.next;
            while (curr != next) {
                ListNode temp = curr.next;
                curr.next = p;
                p = curr;
                curr = temp;
            }

            pre.next = tail;
            con.next = next;

            pre = con;
            tail = con;
        }
    }
}
