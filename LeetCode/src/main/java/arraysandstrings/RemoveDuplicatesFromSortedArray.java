package arraysandstrings;


public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {0,1,1,1,1,2,2,3,3,4};

        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int counter = 1;
        int flag = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (flag < nums[i]) {
                flag = nums[i];
                nums[counter] = flag;
                counter++;
            }
        }
        return counter;
    }
}
