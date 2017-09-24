package main.java.com.valiantsen.lcpractise.tree;

import java.math.BigInteger;

public class TTest {

    public static void main(String[] args) {
        BigInteger b = new BigInteger("281474976710655");
        String uid = new BigInteger("281474976907117").and(new BigInteger("281474976710655")).toString();
        System.out.println(uid);
    }
}
