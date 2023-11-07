package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prasada Rao on 17/10/21 3:56 PM
 *
 * <a herf="https://leetcode.com/problems/permutations/">46. Permutations</a>
 **/
public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, result);
        return result;
    }

    private static void permute(int[] array, int k, List<List<Integer>> result) {
        for (int i = k; i < array.length; i++) {
            swap(array, i, k);
            permute(array, k + 1, result);
            swap(array, k, i);
        }

        if (k == array.length - 1) {
            List<Integer> permutation = new ArrayList<>();
            for (int number : array) {
                permutation.add(number);
            }
            result.add(permutation);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
