package JZOffer;

import utils.ListNode;

/**
 * @author zhengweijun
 * Created on 2020-07-20
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                tail = tail.next;
                l1 = l1.next;
            } else {
                tail.next = l2;
                tail = tail.next;
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            tail.next = l1;
            tail = tail.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            tail.next = l2;
            tail = tail.next;
            l2 = l2.next;
        }
        return head.next;
    }

}
