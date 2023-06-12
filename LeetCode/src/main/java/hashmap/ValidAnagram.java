package hashmap;

import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        HashMap<Character, Integer> hashMap2 = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (hashMap.containsKey(c)) {
                int charAmount = hashMap.get(c);
                charAmount += 1;
                hashMap.put(c, charAmount);
            } else {
                hashMap.put(c, 1);
            }
        }
        for (char c : t.toCharArray()) {
            if (hashMap2.containsKey(c)) {
                int charAmount = hashMap2.get(c);
                charAmount += 1;
                hashMap2.put(c, charAmount);
            } else {
                hashMap2.put(c, 1);
            }
        } return hashMap.equals(hashMap2);
    }
}
