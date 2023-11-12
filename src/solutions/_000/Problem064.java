package solutions._000;

import utils.structs.Triple;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static utils.ContinuedFraction.squareRootContinuedFraction;

public class Problem064 {
    public static void main(String[] args) {
        int cnt = 0;
        for (int n = 2; n <= 10000; n++) {
            int sq = (int) Math.sqrt(n);
            if (n == sq * sq) {
                continue;
            }

            List<Integer> a = new ArrayList<>();
            Iterator<Triple<BigInteger, BigInteger, BigInteger>> cf = squareRootContinuedFraction(BigInteger.valueOf(n));
            while (!check(a)) {
                a.add(cf.next().first().intValue());
            }

            if (a.size() % 2 == 0) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean check(List<Integer> a) {
        if (a.size() <= 1) {
            return false;
        }

        if (2 * a.get(0) != a.get(a.size() - 1)) {
            return false;
        }

        for (int i = 1; 2 * i < a.size(); i++) {
            if (!Objects.equals(a.get(i), a.get(a.size() - i - 1))) {
                return false;
            }
        }

        return true;
    }
}
