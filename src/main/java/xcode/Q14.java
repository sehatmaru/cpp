package xcode;

import java.util.Arrays;

public class Q14 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));
    }

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

}
