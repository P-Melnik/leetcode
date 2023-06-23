package intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};

        System.out.println(summaryRanges(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        int flag = 0;
        int counter = 0;
        List<String> res = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (stringBuilder.isEmpty()) {
                stringBuilder.append(nums[i]);
                if (i == nums.length - 1) res.add(stringBuilder.toString());
                flag = nums[i];
                continue;
            }
            if (nums[i] == flag + 1) {
                flag = nums[i];
                counter++;
                if (i == nums.length - 1) {
                    stringBuilder.append("->" + nums[i]);
                    res.add(stringBuilder.toString());
                }
            } else {
                if (counter > 0) {
                    stringBuilder.append("->" + nums[i - 1]);
                    res.add(stringBuilder.toString());
                    stringBuilder.delete(0, stringBuilder.length());
                    counter = 0;
                } else {
                    res.add(stringBuilder.toString());
                    stringBuilder.delete(0, stringBuilder.length());
                }
                i--;
            }
        }
        return res;
    }
}
