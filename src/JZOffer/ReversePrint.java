package JZOffer;

import java.util.ArrayList;
import java.util.List;

import utils.ListNode;

/**
 * @author zhengweijun
 * Created on 2020-07-19
 */
public class ReversePrint {
    private static List<Integer> list = new ArrayList<>();

    //    public static int[] reversePrint(utils.ListNode head) {
    //        reverseHelp(head);
    //        return list.stream().filter(Objects::nonNull).mapToInt(n -> n).toArray();
    //    }

    //    public static void reverseHelp(utils.ListNode node) {
    //        if (node == null) {
    //            return;
    //        }
    //        if (node.next != null) {
    //            reverseHelp(node.next);
    //        }
    //        list.add(node.val);
    //    }

    public static int[] reversePrint(ListNode head) {
        int size = countListSize(head);
        int[] valList = new int[size];
        ListNode reverseHead = reverse2(head);
        for (int i = 0; i < size; i++) {
            valList[i] = reverseHead.val;
            reverseHead = reverseHead.next;
        }
        return valList;
    }

    public static ListNode reverse1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverse1(head.next);
        head.next.next = head.next;
        head.next = null;
        return node;
    }

    public static ListNode reverse2(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }


    public static int countListSize(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
