package utils.structs;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.util.Objects;

import static java.lang.StrictMath.abs;
import static java.math.BigInteger.valueOf;

public class BigFraction extends Number implements Comparable<BigFraction> {
    public static final BigFraction ZERO = new BigFraction(0, 1);
    public static final BigFraction ONE = new BigFraction(1, 1);
    private final boolean sign; // true if nonnegative
    private final BigInteger n, d;

    private BigFraction(BigInteger a, BigInteger b, boolean sign) {
        n = a;
        d = b;
        this.sign = sign;
    }

    public BigFraction(BigInteger a, BigInteger b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException();
        } else if (b.signum() == 0) {
            throw new ArithmeticException("Division by zero");
        }
        sign = a.signum() * b.signum() >= 0;
        BigInteger g = a.gcd(b);
        n = a.divide(g).abs();
        d = b.divide(g).abs();
    }

    public BigFraction(long a, long b) {
        this(valueOf(a), valueOf(b));
    }

    public BigFraction(BigInteger a) {
        this(a.abs(), BigInteger.ONE, a.signum() >= 0);
    }

    public BigFraction(long a) {
        this(valueOf(abs(a)), BigInteger.ONE, a >= 0);
    }

    public BigFraction add(BigFraction f) {
        BigInteger a = sign ? n : n.negate(), c = f.sign ? f.n : f.n.negate();
        return new BigFraction(a.multiply(f.d).add(c.multiply(d)), d.multiply(f.d));
    }

    public BigFraction subtract(BigFraction f) {
        return add(f.negate());
    }

    public BigFraction multiply(BigFraction f) {
        BigInteger g = n.gcd(f.d), h = f.n.gcd(d);
        return new BigFraction(n.divide(g).multiply(f.n.divide(h)),
                               d.divide(h).multiply(f.d.divide(g)),
                               sign == f.sign || n.signum() == 0 || f.n.signum() == 0);
    }

    public BigFraction divide(BigFraction f) {
        return multiply(f.inverse());
    }

    public BigFraction negate() {
        if (equals(ZERO)) {
            return this;
        }
        return new BigFraction(n, d, !sign);
    }

    public BigFraction inverse() {
        if (equals(ZERO)) {
            throw new ArithmeticException("Division by zero");
        }

        return new BigFraction(d, n, sign);
    }

    public BigFraction pow(int e) {
        if (e < 0) {
            if (equals(ZERO)) {
                throw new ArithmeticException("Division by zero");
            }
            return new BigFraction(d.pow(-e), n.pow(-e), sign || e % 2 == 0);
        } else if (e == 0) {
            if (equals(ZERO)) {
                throw new ArithmeticException("0^0 undefined");
            }
            return ONE;
        } else {
            return new BigFraction(n.pow(e), d.pow(e), sign || e % 2 == 0);
        }
    }

    public BigInteger getNumerator() {
        return n;
    }

    public BigInteger getDenominator() {
        return d;
    }

    public boolean getSign() {
        return sign;
    }

    public boolean isInteger() {
        return d.equals(BigInteger.ONE);
    }

    @Override
    public int intValue() {
        if (isInteger()) {
            return sign ? n.intValueExact() : -n.intValueExact();
        } else {
            throw new ArithmeticException("Fraction does not evaluate to integer");
        }
    }

    @Override
    public long longValue() {
        if (isInteger()) {
            return sign ? n.longValueExact() : -n.longValueExact();
        } else {
            throw new ArithmeticException("Fraction does not evaluate to integer");
        }
    }

    @Override
    public float floatValue() {
        float value = new BigDecimal(n).divide(new BigDecimal(d), MathContext.DECIMAL32).floatValue();
        return sign ? value : -value;
    }

    @Override
    public double doubleValue() {
        double value = new BigDecimal(n).divide(new BigDecimal(d), MathContext.DECIMAL64).doubleValue();
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
        return sign == f.sign && n.equals(f.n) && d.equals(f.d);
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
        return Objects.hash(n, d, sign);
    }

    @Override
    public String toString() {
        String s = n.toString() + '/' + d.toString();
        return sign ? s : '-' + s;
    }
}
