package easy;

import java.util.Arrays;

/**
 * Created by Prasada Rao on 13/10/21 4:22 PM
 *
 * <a href="https://leetcode.com/problems/merge-sorted-array/">88. Merge Sorted Array</a>
 **/
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0) return;

        int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;

        while (tail1 >= 0 && tail2 >= 0) {
            nums1[finished--] = nums1[tail1] > nums2[tail2] ? nums1[tail1--] : nums2[tail2--];

        }

        while (tail2 >= 0) {
            nums1[finished--] = nums2[tail2--];
        }
    }

    public static void main(String[] args) {
        new MergeSortedArray().merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        new MergeSortedArray().merge(new int[]{1}, 1, new int[]{}, 0);
        new MergeSortedArray().merge(new int[]{2, 0}, 1, new int[]{1}, 1);
    }
}
