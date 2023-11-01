package arraysandstrings;

/*
Given a string s consisting of words and spaces,
return the length of the last word in the string.

A word is a maximal
substring
 consisting of non-space characters only.

Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.
Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.
*/

public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "i am going to count tha last word";

        System.out.println(lengthOfLastWord(s));
        System.out.println(lengthOfLastWord2(s));
    }

    public static int lengthOfLastWord(String s) {
        char c = ' ';
        int tail = s.length() - 1;
        while (s.charAt(tail) == c) {
            tail--;
        }
        int counter = 0;
        while (tail >= 0 && s.charAt(tail) != ' ') {
            counter++;
            tail--;
        }
        return counter;
    }

    public static int lengthOfLastWord2(String s) {
        String[] arr = s.split(" ");
        return arr[arr.length - 1].length();
    }


}
