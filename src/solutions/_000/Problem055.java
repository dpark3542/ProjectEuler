package solutions._000;

import java.math.BigInteger;

public class Problem055 {
    /*
     * Brute force: test each number.
     * Bignums are necessary.
     */
    public static void main(String[] args) {
        int cnt = 0;
        out:
        for (int i = 1; i < 10000; i++) {
            BigInteger x = BigInteger.valueOf(i);
            for (int j = 1; j < 50; j++) {
                x = x.add(new BigInteger(new StringBuilder(x.toString()).reverse().toString()));
                if (x.toString().equals(new StringBuilder(x.toString()).reverse().toString())) {
                    continue out;
                }
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
