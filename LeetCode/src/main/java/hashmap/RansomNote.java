package hashmap;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
        String rans = "aa";
        String magazine = "aab";

        System.out.println(canConstruct(rans, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> mapMagazine = new HashMap<>();


        for (int i = 0; i < magazine.length(); i++) {
            if (mapMagazine.containsKey(magazine.charAt(i))) {
                int counter = mapMagazine.get(magazine.charAt(i));
                mapMagazine.put(magazine.charAt(i), counter + 1);
            } else {
                mapMagazine.put(magazine.charAt(i), 1);
            }
        }

        boolean canConstruct = true;
        for (int i = 0; i < ransomNote.length(); i++) {
            if (mapMagazine.containsKey(ransomNote.charAt(i))) {
                mapMagazine.put(ransomNote.charAt(i),
                        mapMagazine.get(ransomNote.charAt(i)) - 1);
                if (mapMagazine.get(ransomNote.charAt(i)) < 0) canConstruct = false;
            } else {
                canConstruct = false;
            }
        } return canConstruct;
    }

}
