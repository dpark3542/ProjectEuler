package solutions;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by dpark on 5/11/2017.
 */
public class Problem029 {
    public static void main(String[] args) {
        Set<BigInteger> s = new HashSet<>();
        for (int a = 2; a <= 100; a++) {
            for (int b = 2; b <= 100; b++) {
                s.add(BigInteger.valueOf(a).pow(b));
            }
        }
        System.out.println(s.size());
    }
}
