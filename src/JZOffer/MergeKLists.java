package JZOffer;

import utils.ListNode;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-08-01
 */
public class MergeKLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int val = findMin(lists);
        while (val != Integer.MAX_VALUE) {
            curr.next = new ListNode(val);
            curr = curr.next;
            val = findMin(lists);
        }
        return head.next;
    }

    public static int findMin(ListNode[] lists) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                if (lists[i].val < min) {
                    min = lists[i].val;
                    index = i;
                }
            }
        }
        if (lists[index] != null) {
            lists[index] = lists[index].next;
        }
        return min;
    }
}
