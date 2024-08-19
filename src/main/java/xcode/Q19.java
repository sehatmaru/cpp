package xcode;

import xcode.model.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Q19 {

    public static void main(String[] args) {
        System.out.println(removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2).toString());
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<Integer> list = new ArrayList<>();
        ListNode result = null;
        ListNode current = head;

        while(current != null) {
            list.add(current.val);

            current = current.next;
        }

        list.remove(list.size() - n);

        int i = list.size() - 1;
        while (i >= 0) {
            result = new ListNode(list.get(i), result);
            i--;
        }

        return result;
    }

}
