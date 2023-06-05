package org.example;

public class MergeTwoSortedArrays {
    
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 4, 5};

        merge(nums1, 3, nums2, 3);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        if (m == 0) nums1[0] = nums2[0];
        for (int t = m + n - 1, i = m - 1, j = n - 1; t >= 0 && j >= 0; t--) {
            if (i < 0) {
                nums1[t] = nums2[j];
                j--;
            }
            else if (nums1[i] <= nums2[j]) {
                nums1[t] = nums2[j];
                j--;
            } else {
                nums1[t] = nums1[i];
                i--;
            }
        }
    }
}
