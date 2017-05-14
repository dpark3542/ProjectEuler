package solutions.java;

import java.math.BigInteger;

/*
 * Created by dpark3542 on 5/11/2017.
 */
public class Problem025 {
    public static void main(String[] args) {
        int n = 2;
        BigInteger a = BigInteger.ONE, b = BigInteger.ONE;
        while (b.toString().length() < 1000) {
            BigInteger c = b;
            b = a.add(b);
            a = c;
            n++;
        }
        System.out.println(n);
    }
}
