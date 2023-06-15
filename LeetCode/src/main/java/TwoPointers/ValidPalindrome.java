package TwoPointers;

public class ValidPalindrome {
    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";

        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String s1 = s.toLowerCase();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) >= '0' && s1.charAt(i) <= '9'
                    || s1.charAt(i) >= 'a' && s1.charAt(i) <= 'z') {
                stringBuilder.append(s1.charAt(i));
            }
        }
        s1 = stringBuilder.toString();
        if (s1.length() <= 1) return true;
        for (int i = 0, j = s1.length() - 1; i < j; i++, j--) {
            if (s1.charAt(i) != s1.charAt(j)) return false;
        }
        return true;
    }
}
