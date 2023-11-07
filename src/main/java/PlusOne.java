import java.util.Arrays;

/**
 * Created by Prasada Rao on 12/10/21 1:14 PM
 *
 * <a href="https://leetcode.com/problems/plus-one/">66. Plus One</a>
 **/
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNumber = new int[length + 1];
        newNumber[0] = 1;
        return newNumber;
    }

    public int[] plusOne1(int[] digits) {
        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1] += 1;
            return digits;
        }
        int carry = 1;
        digits[digits.length - 1] = 0;
        for (int i = digits.length - 2; i >= 0; i--) {
            int sum = digits[i] + carry;
            if (sum <= 9) {
                carry = 0;
                digits[i] = sum;
                break;
            } else {
                digits[i] = 0;
            }
        }
        if (carry > 0) {
            int[] result = new int[digits.length + 1];
            result[0] = carry;
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{9})));
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{9, 9})));
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})));
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 6})));
    }
}
