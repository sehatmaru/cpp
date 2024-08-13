package xcode;

import java.util.Arrays;

public class Q6 {

    public static void main(String[] args) {
        System.out.println(convert("Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.", 3));
    }

    public static String convert(String s, int numRows) {
        int diff = 0;
        int numCols = 100000;
        String[][] map = new String[numRows][numCols];
        StringBuilder result = new StringBuilder();

        int counter = 0;
        int currentRow = numRows-2;

        int i = 0;

        while (counter != s.length()) {
            if (diff > 0) {
                map[currentRow][i] = String.valueOf(s.charAt(counter));

                currentRow--;
                counter++;
                diff--;

                if (diff == 0) currentRow = 0;
            } else {
                for (int j = 0; j < numRows; j++) {
                    map[j][i] = String.valueOf(s.charAt(counter));
                    counter++;

                    if (counter == s.length()) break;
                }

                diff = numRows - 2;
                currentRow = numRows - 2;
            }

            i++;
        }

        for (int p=0; p<numRows; p++) {
            for (int j=0; j<numCols; j++) {
                String val = map[p][j];
                if (val != null) result.append(val);
            }
        }

        return result.toString();
    }

}
