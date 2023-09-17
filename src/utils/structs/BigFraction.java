package utils.structs;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class BigFraction extends Number implements Comparable<BigFraction> {
    private final boolean sign; // true if nonnegative
    private final BigInteger n, d;

    public static final BigFraction ZERO = new BigFraction(0, 1);
    public static final BigFraction ONE = new BigFraction(1, 1);

    private BigFraction(BigInteger a, BigInteger b, boolean sign) {
        n = a;
        d = b;
        this.sign = sign;
    }

    public BigFraction(BigInteger a, BigInteger b) {
        if (b.compareTo(BigInteger.ZERO) == 0) {
            throw new ArithmeticException("Division by zero");
        }
        sign = a.compareTo(BigInteger.ZERO) == 0 || a.compareTo(BigInteger.ZERO) * b.compareTo(BigInteger.ZERO) > 0;
        BigInteger g = a.gcd(b);
        n = a.divide(g).abs();
        d = b.divide(g).abs();
    }

    public BigFraction(long a, long b) {
        this(BigInteger.valueOf(a), BigInteger.valueOf(b));
    }

    public BigFraction add(BigFraction f) {
        BigInteger a = sign ? n : n.negate(), c = f.sign ? f.n : f.n.negate();
        return new BigFraction(a.multiply(f.d).add(c.multiply(d)), d.multiply(f.d));
    }

    public BigFraction multiply(BigFraction f) {
        BigInteger g = n.gcd(f.d), h = f.n.gcd(d);
        boolean newSign = sign == f.sign || n.compareTo(BigInteger.ZERO) == 0 || f.n.compareTo(BigInteger.ZERO) == 0;
        return new BigFraction(n.divide(g).multiply(f.n.divide(h)), d.divide(h).multiply(f.d.divide(g)), newSign);
    }

    public BigFraction negate() {
        if (n.compareTo(BigInteger.ZERO) == 0) {
            return this;
        }
        return new BigFraction(n, d, !sign);
    }

    public BigFraction inverse() {
        return new BigFraction(d, n, sign);
    }

    @Override
    public int intValue() {
        int value = n.divide(d).intValue();
        return sign ? value : -value;
    }

    @Override
    public long longValue() {
        long value = n.divide(d).longValue();
        return sign ? value : -value;
    }

    @Override
    public float floatValue() {
        float value = new BigDecimal(n).divide(new BigDecimal(d), MathContext.DECIMAL32).floatValue();
        return sign ? value : -value;
    }

    @Override
    public double doubleValue() {
        double value = new BigDecimal(n).divide(new BigDecimal(d), MathContext.DECIMAL32).doubleValue();
        return sign ? value : -value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (!(obj instanceof BigFraction)) {
            return false;
        }
        BigFraction f = (BigFraction) obj;
        return n.equals(f.n) && d.equals(f.d) && sign == f.sign;
    }

    @Override
    public int compareTo(BigFraction o) {
        if (sign && !o.sign) {
            return 1;
        }
        if (!sign && o.sign) {
            return -1;
        }
        int c = n.multiply(o.d).compareTo(o.n.multiply(d));
        return sign ? c : -c;
    }

    @Override
    public int hashCode() {
        return n.hashCode() * 31 + d.hashCode();
    }

    @Override
    public String toString() {
        if (sign) {
            return n.toString() + '/' + d.toString();
        }
        return '-' + n.toString() + '/' + d.toString();
    }
}
