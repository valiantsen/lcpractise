package main.java.com.valiantsen.ama.oa;

public class BinaryNumerPalindrom {

    public boolean isPalindrom(int x) {

        int i = 0, l = 0, flag = 0;
        int[] a = new int[33];
        while (x != 0) {
            a[l++] = x % 2;
            x /= 2;
        }
        return validP(a, 0, l);
    }

    private boolean validP(int[] m, int start, int end) {
        for (int i = start; i < end; i++) {
            if (m[i] != m[end - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BinaryNumerPalindrom a = new BinaryNumerPalindrom();
        System.out.println(a.isPalindrom(27));
    }
}
