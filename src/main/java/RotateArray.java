import java.util.Arrays;

/**
 * Created by Prasada Rao on 11/10/21 10:14 AM
 * <p>
 * See <a href="https://leetcode.com/problems/rotate-array/">rotate-array</a>
 **/
public class RotateArray {

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        for (int i = 0; i < nums.length / 2; i++) {
            swap(nums, i, nums.length - 1 - i);
        }
        for (int i = 0; i < k / 2; i++) {
            swap(nums, i, k - 1 - i);
        }
        for (int i = k; i < (nums.length + k) / 2; i++) {
            swap(nums, i, nums.length + k - 1 - i);
        }
    }

    public void rotate1(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = nums.length - 1; j > 0; j--) {
                swap(nums, j, j - 1);
            }
        }
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
//        rotateArray.rotate(nums, 3);
//        System.out.println(Arrays.toString(nums));
//        nums = new int[]{-1, -100, 3, 99};
//        rotateArray.rotate(nums, 2);
//        System.out.println(Arrays.toString(nums));
        nums = new int[]{-1};
        rotateArray.rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{1,2,3,4,5,6};
        rotateArray.rotate(nums, 11);
        System.out.println(Arrays.toString(nums));
    }
}
