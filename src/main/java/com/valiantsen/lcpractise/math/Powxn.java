package main.java.com.valiantsen.lcpractise.math;

/**
 * Implement pow(x, n).
 * 
 * 
 * @ClassName: Powxn
 * @author zhangyasen
 * @date 2017年10月12日
 */
public class Powxn {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (x == 0) {
            return 0;
        }
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                n++; // Make -2147483648 to -2147483647
                if (x < 0) {
                    x = -x; // we made n odd so need to update sign
                }
            }
            n = -n;
            x = 1 / x;
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
