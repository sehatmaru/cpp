package xcode;

import java.util.Arrays;

public class Q28 {

    public static void main(String[] args) {
        System.out.println(strStr("leetcode", "code"));
    }

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

}
