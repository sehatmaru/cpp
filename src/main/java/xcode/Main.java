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
//        System.out.println(mergeTwoLists(new ListNode(5, new ListNode(3)), new ListNode(8, new ListNode(6, new ListNode(9)))).toString());
//        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
//        System.out.println(removeElement(new int[]{0,0,1,1,1,2,2,3,3,4}, 0));
//        System.out.println(strStr("leetcode", "code"));
//        System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
//        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
//        System.out.println(deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))))));
//        System.out.println(isSameTree(new TreeNode(1, new TreeNode(2), new TreeNode(3)), new TreeNode(1, new TreeNode(), new TreeNode(3))));
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

//    21. Merge Two Sorted Lists
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

        return listNodes.size() > 0 ? listNodes.get(0) : null;
    }

//    26. Remove Duplicates from Sorted Array
    public static int removeDuplicates(int[] nums) {
        int result = 0;

        for (int i=0; i<nums.length; i++) {
            if (nums[result] < nums[i]) {
                result++;
                nums[result] = nums[i];
            }
        }

        return result;
    }

//    27. Remove Element
    public static int removeElement(int[] nums, int val) {
        int counter = 0;

        for (int i=0; i<nums.length; i++) {
            if (nums[i] != val) {
                if (counter != i) nums[counter] = nums[i];

                counter++;
            }
        }

        return counter;
    }

//    28. Find the Index of the First Occurrence in a String
    public static int strStr(String haystack, String needle) {
        int result = -1;

        if (haystack.contains(needle)) {
            for (int i=0; i<haystack.length(); i++) {
                if (haystack.charAt(i) == needle.charAt(0)) {
                    result = i;

                    if (needle.length() == 1) return result;

                    for (int j=1; j<needle.length(); j++) {
                        if (haystack.charAt(i+j) != needle.charAt(j)) break;
                        if (haystack.charAt(i + j) == needle.charAt(j) && j == needle.length() - 1) {
                            return result;
                        }
                    }
                }
            }
        }

        return result;
    }

//    35. Search Insert Position
    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 1) {
            return target >= nums[0] ? 1 : 0;
        }

        for (int i=0; i<nums.length; i++) {
            if (i == nums.length-1) {
                return nums.length;
            }

            if (nums[i] <= target && nums[i+1] >= target) {
                return i+1;
            }
        }

        return 0;
    }

//    58. Length of Last Word
    public static int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        return arr[arr.length-1].length();
    }

//    83. Remove Duplicates from Sorted List
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

//    100. Same Tree
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}