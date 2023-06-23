package hashmap;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat dog dog";

        System.out.println(wordPattern(pattern, s));
        System.out.println(wordPattern2(pattern, s));
    }

    public static boolean wordPattern(String pattern, String s) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<Character, String> map = new HashMap<>();
        String[] arr = s.split(" ");
        if (pattern.length() != arr.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) continue;
            if (map.containsValue(arr[i])) return false;
            map.put(pattern.charAt(i), arr[i]);
        }
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                stringBuilder.append(map.get(pattern.charAt(i)));
            }
            if (i < pattern.length() - 1) {
                stringBuilder.append(" ");
            }
        }
        System.out.println(map);
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString().equals(s);
    }

    // better solution
    public static boolean wordPattern2(String pattern, String s) {
        String[] arr = s.split(" ");
        if (pattern.length() != arr.length) return false;
        Map map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            if (map.put(pattern.charAt(i), i) != map.put(arr[i], i)) return false;
        }
        return true;
    }
}
