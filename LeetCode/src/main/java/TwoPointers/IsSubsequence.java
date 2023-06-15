package TwoPointers;

public class IsSubsequence {

    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";

        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (t.length() < s.length() || t.length() == 0) return false;
        for (int i = 0, j = 0; i < s.length(); ) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
            if (i < s.length() && j == t.length()) return false;
        }
        return true;
    }
}
