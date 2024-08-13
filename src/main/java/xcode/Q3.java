package xcode;

import java.util.ArrayList;
import java.util.List;

public class Q3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabc"));
    }

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

}
