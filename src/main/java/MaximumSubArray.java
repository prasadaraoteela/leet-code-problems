/**
 * Created by Prasada Rao on 11/10/21 6:16 PM
 * <p>
 * <a href="https://leetcode.com/problems/maximum-subarray/">53. Maximum Subarray</a>
 **/
public class MaximumSubArray {

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];

        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public int maxSubArray1(int[] nums) {
        if (nums.length == 1) return nums[0];

        int max_so_far = Integer.MIN_VALUE;
        int max_ending_here = 0;

        for (int num : nums) {

            max_ending_here += num;

            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
            }
            if (max_ending_here < 0) {
                max_ending_here = 0;
            }
        }
        return max_so_far;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSubArray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new MaximumSubArray().maxSubArray(new int[]{5, 4, -1, 7, 8}));
        System.out.println(new MaximumSubArray().maxSubArray(new int[]{-2, -2, -3, 0}));
    }
}
