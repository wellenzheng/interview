package JZOffer;

import utils.ListNode;

/**
 * @author zhengweijun
 * Created on 2020-07-20
 */
public class DeleteNode {

    public static ListNode deleteNode(ListNode head, int val) {
        if (head != null && head.val == val) {
            return head.next;
        }
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
                return head;
            }
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
