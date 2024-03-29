package solutions._100;

import java.util.ArrayList;
import java.util.List;

import static java.lang.StrictMath.floor;
import static java.lang.StrictMath.min;
import static java.lang.StrictMath.sqrt;

public class Problem142 {
    public static void main(String[] args) {
        long min = Long.MAX_VALUE;
        for (long a = 1; min > 3 * a * a / 4; a++) {
            List<Long> l = new ArrayList<>(), m = new ArrayList<>();
            for (long c = 1; c < a / sqrt(2); c++) {
                double b = sqrt(a * a - c * c);
                if (b == floor(b)) {
                    l.add((long) b);
                    m.add(c);
                }
            }
            for (int i = 0; i < l.size(); i++) {
                for (int j = i + 1; j < l.size(); j++) {
                    long d = l.get(i), e = m.get(i);
                    long b, c;
                    if ((l.get(i) - l.get(j)) % 2 == 0) {
                        b = l.get(j);
                        c = m.get(j);
                    }
                    else {
                        b = m.get(j);
                        c = l.get(j);
                    }
                    long x = (b * b - c * c + d * d - e * e) / 2, sq = (long) sqrt(x);
                    if (x == sq * sq) {
                        long s = (c * c + 2 * d * d + e * e) / 2;
                        min = min(min, s);
                    }
                }
            }
        }
        System.out.println(min);
    }
}
