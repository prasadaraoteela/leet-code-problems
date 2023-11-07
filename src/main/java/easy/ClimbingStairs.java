package easy;

/**
 * Created by Prasada Rao on 13/10/21 4:07 PM
 *
 * <a href="https://leetcode.com/problems/climbing-stairs/">70. Climbing Stairs</a>
 **/
public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n <= 1) return n;
        int[] f = new int[n + 1];
        f[0] = f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public int climbStairs1(int n) {
        if (n <= 1) return 1;

        int[] f = new int[n + 1];
        climbStairs(n, f);
        return f[n];
    }

    private int climbStairs(int n, int[] f) {
        if (n <= 1) return 1;
        if (f[n] != 0) return f[n];

        f[n - 1] = climbStairs(n - 1, f);
        f[n - 2] = climbStairs(n - 2, f);

        f[n] = f[n - 1] + f[n - 2];
        return f[n];
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(2));
        System.out.println(new ClimbingStairs().climbStairs(3));
        System.out.println(new ClimbingStairs().climbStairs(10));
    }
}
