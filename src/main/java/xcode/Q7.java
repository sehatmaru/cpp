package xcode;

public class Q7 {

    public static void main(String[] args) {
        System.out.println(reverse(120));
    }

    public static int reverse(int x) {
        long reversedNumber = 0;

        while (x != 0) {
            int digit = x % 10;
            reversedNumber = reversedNumber * 10 + digit;
            x /= 10;
        }

        if (reversedNumber > Integer.MAX_VALUE || reversedNumber < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) reversedNumber;
    }

}
