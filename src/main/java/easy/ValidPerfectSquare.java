package easy;

/**
 * Created by Prasada Rao on 13/10/21 10:25 AM
 *
 * <a href="https://leetcode.com/problems/valid-perfect-square/">367. Valid Perfect Square</a>
 **/
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        int sqrt = sqrt(num);
        return sqrt * sqrt == num;
    }

    private int sqrt(int num) {
        if (num <= 1) return num;

        int start = 1, end = num;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (mid <= num / mid && (mid + 1) > num / (mid + 1)) {
                return mid;
            }
            if (mid > num / mid) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPerfectSquare().isPerfectSquare(16));
        System.out.println(new ValidPerfectSquare().isPerfectSquare(8));
    }
}
