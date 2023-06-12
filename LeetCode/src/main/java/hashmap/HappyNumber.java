package hashmap;

import java.util.HashMap;
import java.util.Map;

public class HappyNumber {

    public static void main(String[] args) {
        int n = 1;

        System.out.println(isHappy(n));
    }

    public static boolean isHappy(int n) {
        if (n == 1) return true;
        Map<Integer, Integer> map = new HashMap<>();
        while (!map.containsValue(1)) {
            map.put(n, pow(n));
            n = pow(n);
            if (map.containsKey(n)) return false;
        }
        return true;
    }

    public static int pow(int n) {
        int res = 0;
        String s = String.valueOf(n);
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = Character.getNumericValue(s.charAt(i));
            res += arr[i] * arr[i];
        }
        return res;
    }
}
