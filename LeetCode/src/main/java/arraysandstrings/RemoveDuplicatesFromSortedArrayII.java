package arraysandstrings;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};

        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int flag = nums[0];
        int counter = 1;
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != flag) {
                flag = nums[i];
                counter = 1;
            } else {
                counter++;
            }
            if (counter > 2) {
                res++;
                nums[i] = 10001;
            }
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        return nums.length - res;
    }
}
