/**
 * Created by Prasada Rao on 12/10/21 3:42 PM
 *
 * <a href="https://leetcode.com/problems/sqrtx/">69. Sqrt(x)</a>
 **/
public class SquareRoot {

    public int mySqrt(int x) {
        if (x <= 1) return x;

        int start = 1, end = x;
        // if i * i <= x and (i + 1) * (i + 1) > x then i is sqrt of x
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            }
            if (mid > x / mid) { // Keep checking left part
                end = mid;
            } else { // Keep checking right part
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(new SquareRoot().mySqrt(16));
        System.out.println(new SquareRoot().mySqrt(256));
        System.out.println(new SquareRoot().mySqrt(8));
        System.out.println(new SquareRoot().mySqrt(2147395599));
    }
}
