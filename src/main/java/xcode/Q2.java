package xcode;

import xcode.model.ListNode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q2 {

    public static void main(String[] args) {
        System.out.println(addTwoNumbers(new ListNode(5, new ListNode(3)), new ListNode(8, new ListNode(6, new ListNode(9)))).toString());
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean eol1 = false;
        boolean eol2 = false;
        List<Integer> numbersA = new ArrayList<>();
        List<Integer> numbersB = new ArrayList<>();

        while (!eol1) {
            numbersA.add(l1.val);
            if (l1.next != null) {
                l1 = l1.next;
            } else {
                eol1 = true;
            }
        }

        while (!eol2) {
            numbersB.add(l2.val);
            if (l2.next != null) {
                l2 = l2.next;
            } else {
                eol2 = true;
            }
        }

        Collections.reverse(numbersA);
        Collections.reverse(numbersB);

        StringBuilder stringA = new StringBuilder();
        StringBuilder stringB = new StringBuilder();

        for (Integer value : numbersA) {
            stringA.append(value);
        }

        for (Integer value : numbersB) {
            stringB.append(value);
        }

        BigInteger numA = new BigInteger(stringA.toString());
        BigInteger numB = new BigInteger(stringB.toString());

        BigInteger sum = numA.add(numB);
        String sumString = String.valueOf(sum);

        List<ListNode> listNodes = new ArrayList<>();

        for (int i = sumString.length()-1; i >= 0; i--) {
            char digit = sumString.charAt(i);
            int digitValue = Character.getNumericValue(digit);

            listNodes.add(new ListNode(digitValue));
        }

        for (int i=0; i< listNodes.size(); i++) {
            if (i != listNodes.size() - 1) listNodes.get(i).next = listNodes.get(i+1);
        }

        return listNodes.get(0);
    }


}
