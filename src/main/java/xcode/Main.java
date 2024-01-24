package xcode;

import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 4}, 6)));
//        System.out.println(addTwoNumbers(new ListNode(5, new ListNode(3)), new ListNode(8, new ListNode(6, new ListNode(9)))).toString());
//        System.out.println(lengthOfLongestSubstring("abcabc"));
//        System.out.println(isPalindrome(242));
//        System.out.println(romanToInt("XII"));
//        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));
    }

//    1. Two Sum
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        boolean done = false;

        for (int i=0; i<nums.length; i++) {
            for (int j=i; j<nums.length; j++) {
                int a = nums[i];
                int b = nums[j];

                int sum = a+b;

                if (sum == target) {
                    result[0] = i;
                    result[1] = j;
                    done = true;
                }

                if (done) break;
            }

            if (done) break;
        }

        return result;
    }

//    2. Add Two Numbers
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

        List<ListNode> listnodes = new ArrayList<>();

        for (int i = sumString.length()-1; i >= 0; i--) {
            char digit = sumString.charAt(i);
            int digitValue = Character.getNumericValue(digit);

            listnodes.add(new ListNode(digitValue));
        }

        for (int i=0; i< listnodes.size(); i++) {
            if (i != listnodes.size() - 1) listnodes.get(i).next = listnodes.get(i+1);
        }

        return listnodes.get(0);
    }

//    3. Longest Substring Without Repeating Characters
    public static int lengthOfLongestSubstring(String s) {
        List<Character> result = new ArrayList<>();

        for (int i=0; i<s.length(); i++) {
            List<Character> temp = new ArrayList<>();
            temp.add(s.charAt(i));

            for (int j=i; j<s.length(); j++) {
                if (i == s.length() - 1) {
                    temp.add('a');
                    break;
                }

                if (j == s.length() - 1) break;

                boolean isDuplicate = false;

                for (Character k : temp) {
                    if (k == s.charAt(j+1)) {
                        isDuplicate = true;
                        break;
                    }
                }

                if (isDuplicate) break;
                else temp.add(s.charAt(j+1));
            }

            if (temp.size() > result.size()) result = temp;
        }

        return result.size();
    }

//    9. Palindrome Number
    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        String reversed = "";

        for (int i=s.length()-1; i>=0; i--) {
            reversed += s.charAt(i);
        }

        return s.equals(reversed);
    }

//    13. Roman to Integer
    public static int romanToInt(String s) {
        int result = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i=0; i<s.length(); i++) {
            char current = s.charAt(i);
            boolean eol = i == s.length() - 1;
            if (current == 'I' && !eol && (s.charAt(i+1) == 'X' || s.charAt(i+1) == 'V')) result -= map.get('I');
            else if (current == 'X' && !eol && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')) result -= map.get('X');
            else if (current == 'C' && !eol && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')) result -= map.get('C');
            else result += map.get(current);
        }

        return result;
    }

//    14. Longest Common Prefix
    public static String longestCommonPrefix(String[] strs) {
        String base = strs[0];
        StringBuilder temp = new StringBuilder();

        for (int i=0; i<base.length(); i++) {
            boolean contain = true;
            char current = base.charAt(i);


            for (int j=1; j<strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != current) {
                    contain = false;
                    break;
                }
            }

            if (!contain) {
                break;
            }

            temp.append(current);
        }

        return temp.toString();
    }

//    20. Valid Parentheses
    public static boolean isValid(String s) {

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}