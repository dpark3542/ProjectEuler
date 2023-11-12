package solutions._000;

import utils.structs.InfiniteIterator;
import utils.structs.Triple;

import java.math.BigInteger;
import java.util.Iterator;

import static utils.ContinuedFraction.continuedFraction;
import static utils.Miscellaneous.digitSum;

public class Problem065 {
    private static final int n = 100;

    public static void main(String[] args) {
        Iterator<Triple<BigInteger, BigInteger, BigInteger>> cf = continuedFraction(new InfiniteIterator<>() {
            private int i = 0;

            @Override
            public BigInteger next() {
                i++;
                if (i == 1) {
                    return BigInteger.TWO;
                } else if (i % 3 == 0) {
                    return BigInteger.valueOf(2L * i / 3);
                } else {
                    return BigInteger.ONE;
                }
            }
        });

        for (int i = 0; i < n - 1; i++) {
            cf.next();
        }

        System.out.println(digitSum(cf.next().second()));
    }
}
