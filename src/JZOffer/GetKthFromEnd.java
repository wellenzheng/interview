package JZOffer;

import utils.ListNode;

/**
 * @author zhengweijun
 * Created on 2020-07-20
 */
public class GetKthFromEnd {

    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && k > 0) {
            p2 = p2.next;
            k--;
        }
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

}
