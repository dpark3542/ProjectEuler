package solutions;

import java.math.BigInteger;

/**
 * Created by dpark on 5/7/2017.
 */
public class Problem016 {
    public static void main(String[] args) {
        int sum = 0;
        String s = BigInteger.valueOf(2).pow(1000).toString();
        for (int i = 0; i < s.length(); i++) {
            sum += Integer.parseInt(s.substring(i, i + 1));
        }
        System.out.println(sum);
    }
}
