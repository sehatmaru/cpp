package xcode;

public class Q12 {

    public static void main(String[] args) {
        System.out.println(intToRoman(3749));
    }

    public static String intToRoman(int num) {
        String result = "";
        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] notation={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        int i = 0;
        while (num > 0) {
            if (num >= values[i]) {
                result += notation[i];
                num -= values[i];
            } else {
                i++;
            }
        }

        return result;
    }

}
