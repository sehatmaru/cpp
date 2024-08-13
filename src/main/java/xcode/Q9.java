package xcode;

public class Q9 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(242));

    }

    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        String reversed = "";

        for (int i=s.length()-1; i>=0; i--) {
            reversed += s.charAt(i);
        }

        return s.equals(reversed);
    }

}
