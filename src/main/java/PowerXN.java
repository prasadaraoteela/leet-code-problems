/**
 * Created by Prasada Rao on 09/10/21 1:00 PM
 **/
public class PowerXN {

    public double myPow(double x, int n) {

        double answer = 1.0;
        long longExponent = n;

        longExponent = longExponent < 0 ? -longExponent : longExponent;

        while (longExponent > 0) {

            if (longExponent % 2 == 0) {

                x *= x;
                longExponent /= 2;

            } else {

                answer *= x;
                longExponent--;

            }
        }
        return n > 0 ? answer : 1.0 / answer;
    }

    public double myPow1(double x, int n) {
        if (n > 0) {
            return power(x, n);
        } else {
            return 1.0 / power(x, -(long) n);
        }
    }

    private double power(double x, long exponent) {
        if (exponent == 0) {
            return 1;
        }
        double a = power(x, exponent / 2);
        double aa = a * a;

        if (exponent % 2 == 1) {
            aa *= x;
        }
        return aa;
    }

    public static void main(String[] args) {
//        System.out.println(new PowerXN().myPow(2.00000, 10));
//        System.out.println(new PowerXN().myPow(2.10000, 3));
//        System.out.println(new PowerXN().myPow(2.00000, -2));
        System.out.println(new PowerXN().myPow(2.00000, -2147483648));
        System.out.println(new PowerXN().myPow(-1.00000, -2147483648));
    }
}
