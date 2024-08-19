package xcode;

import xcode.model.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q21 {

    public static void main(String[] args) {
        System.out.println(mergeTwoLists(new ListNode(5, new ListNode(3)), new ListNode(8, new ListNode(6, new ListNode(9)))).toString());
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<=50; i++) {
            if (list1 != null) {
                list.add(list1.val);

                if (list1.next != null) list1 = list1.next;
                else break;
            }
        }

        for (int i=0; i<=50; i++) {
            if (list2 != null) {
                list.add(list2.val);

                if (list2.next != null) list2 = list2.next;
                else break;
            }
        }

        list.sort(Collections.reverseOrder());

        List<ListNode> listNodes = new ArrayList<>();

        for (int i = list.size()-1; i >= 0; i--) {
            listNodes.add(new ListNode(list.get(i)));
        }

        for (int i=0; i< listNodes.size(); i++) {
            if (i != listNodes.size() - 1) listNodes.get(i).next = listNodes.get(i+1);
        }

        return !listNodes.isEmpty() ? listNodes.get(0) : null;
    }

}
