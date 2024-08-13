package xcode;

import java.util.Arrays;
import java.util.HashMap;

public class Q13 {

    public static void main(String[] args) {
        System.out.println(romanToInt("XII"));
    }

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

}
