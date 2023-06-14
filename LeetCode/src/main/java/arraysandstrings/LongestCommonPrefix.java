package arraysandstrings;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};

        String s = "abcd";


        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        int counter = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < min) min = strs[i].length();
        }
        while (counter < min) {
            for (int i = 0; i < strs.length; i++) {
                char c = strs[0].charAt(counter);
                if (strs[i].charAt(counter) == c) {
                    if (i == strs.length - 1) {
                        counter++;
                    }
                } else return strs[0].substring(0, counter);
            }
        }
        return strs[0].substring(0, counter);
    }
}
