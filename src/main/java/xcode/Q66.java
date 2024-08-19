package xcode;

public class Q66 {

    public static void main(String[] args) {
        System.out.println(plusOne(new int[]{9,8,9}));
    }

    public static int[] plusOne(int[] digits) {
        if (digits.length == 1) {
            if (digits[0] == 9) {
                return new int[]{1,0};
            } else {
                return new int[]{digits[0]+1};
            }
        }

        for (int i = digits.length-1; i > 0 ; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                break;
            } else {
                digits[i] = 0;
                digits[i-1]++;

                if (digits[i-1] <= 9) break;
            }
        }

        if (digits[0] == 10) {
            digits = new int[digits.length+1];
            digits[0] = 1;
        }

        return digits;
    }
}
