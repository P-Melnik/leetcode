package arraysandstrings;

public class RomainToInteger {

    public static void main(String[] args) {
        String s = "MCMXCIV";

        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        char[] arr = s.toCharArray();
        int[] intArr = new int[arr.length];
        int i = 0;
        for (char c : arr) {
            if (c == 'M') {
                intArr[i] = 1000;
            } else if (c == 'D') {
                intArr[i] = 500;
            } else if (c == 'C') {
                intArr[i] = 100;
            } else if (c == 'L') {
                intArr[i] = 50;
            } else if (c == 'X') {
                intArr[i] = 10;
            } else if (c == 'V') {
                intArr[i] = 5;
            } else {
                intArr[i] = 1;
            }
            i++;
        }
        int res = 0;
        for (int j = 0; j < intArr.length ; j++) {
            if (j != intArr.length - 1) {
                if (intArr[j] >= intArr[j + 1]) {
                    res += intArr[j];
                } else {
                    res += intArr[j + 1] - intArr[j];
                    j++;
                }
            } else {
                res += intArr[j];
            }
        }
        return res;
    }
}

