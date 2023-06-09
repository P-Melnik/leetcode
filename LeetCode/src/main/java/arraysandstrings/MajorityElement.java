package arraysandstrings;


import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 5, 7, 3, 3}; // 2 3 3 3 5 7

        System.out.println(majorityElement(nums));
        System.out.println(majorityElement1(nums));
    }


    public static int majorityElement(int[] nums) {
        var majorNumber = nums.length / 2;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            var current = hashMap.get(nums[i]);
            if (current == null) {
                hashMap.put(nums[i], 1);
                current = 1;
            } else {
                hashMap.put(nums[i], current++);
                current++;
            }
            if (current >= majorNumber) {
                return nums[i];
            }
        }
        return -1;
    }



    public static int majorityElement1(int[] nums) {
        if (nums.length == 1) return nums[0];
        int n = nums.length/2;
        Arrays.sort(nums);
        int counter = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                counter++;
                if (counter >= n) return nums[i];
            } else {
                counter = 1;
            }
        }
        return 0;
    }

}
