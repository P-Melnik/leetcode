package hashmap;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,2,3};
        int k = 0;

        System.out.println(containsNearbyDuplicate(nums, k));

    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        while (counter <= nums.length) {
            for (int i = counter; i <= counter + k && i < nums.length; i++) {
                System.out.println("size : " + map.size());
                if (map.size() == k + 1) {
                    map.remove(nums[i - counter]);
                }
                if (map.containsKey(nums[i])) return true;
                map.put(nums[i], 1);
            }
            counter += k + 1;
        }
        return false;
    }
}
