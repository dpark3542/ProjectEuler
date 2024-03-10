package utils;

import utils.structs.InfiniteIterator;
import utils.structs.Triple;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

public final class ContinuedFraction {
    public static Iterator<Triple<BigInteger, BigInteger, BigInteger>> continuedFraction(Iterator<BigInteger> a) {
        return new Iterator<>() {
            private BigInteger hp = ZERO, h = ONE, kp = ONE, k = ZERO;

            @Override
            public boolean hasNext() {
                return a.hasNext();
            }

            @Override
            public Triple<BigInteger, BigInteger, BigInteger> next() {
                if (!a.hasNext()) {
                    throw new NoSuchElementException();
                }

                BigInteger x = a.next(), hpp = hp, kpp = kp;
                hp = h;
                kp = k;
                h = x.multiply(h).add(hpp);
                k = x.multiply(k).add(kpp);
                return new Triple<>(x, h, k);
            }
        };
    }

    public static Iterator<Triple<BigInteger, BigInteger, BigInteger>> squareRootContinuedFraction(BigInteger n) {
        if (n.signum() < 0) {
            throw new IllegalArgumentException();
        }

        BigInteger[] sqr = n.sqrtAndRemainder();
        BigInteger sq = sqr[0];
        if (sqr[1].signum() == 0) {
            return continuedFraction(new Iterator<>() {
                private boolean hasNext = true;

                @Override
                public boolean hasNext() {
                    return hasNext;
                }

                @Override
                public BigInteger next() {
                    if (hasNext) {
                        hasNext = false;
                        return sq;
                    } else {
                        throw new NoSuchElementException();
                    }
                }
            });
        }

        return continuedFraction(new InfiniteIterator<>() {
            private BigInteger p = ZERO, q = n, a = ZERO;

            @Override
            public BigInteger next() {
                p = a.multiply(q).subtract(p);
                q = n.subtract(p.multiply(p)).divide(q);
                a = p.add(sq).divide(q);
                return a;
            }
        });
    }
}
