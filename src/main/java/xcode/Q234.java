package xcode;

import xcode.model.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q234 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))));;
    }

    public static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        List<Integer> reversed = new ArrayList<>(list);
        Collections.copy(reversed, list);
        Collections.reverse(reversed);

        for (int i = 0; i < reversed.size(); i++) {
            if (reversed.get(i) != list.get(i)) return false;
        }

        return true;
    }

}
