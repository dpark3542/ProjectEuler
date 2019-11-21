package solutions._100;

import java.util.ArrayList;
import java.util.List;

public class Problem142 {
    public static void main(String[] args) {
        long min = Long.MAX_VALUE;
        for (long a = 1; min > 3 * a * a / 4; a++) {
            List<Long> l = new ArrayList<>(), m = new ArrayList<>();
            for (long c = 1; c < a / Math.sqrt(2); c++) {
                double b = Math.sqrt(a * a - c * c);
                if (b == Math.floor(b)) {
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
                    long x = (b * b - c * c + d * d - e * e) / 2;
                    if (Math.sqrt(x) == Math.floor(Math.sqrt(x))) {
                        long s = (c * c + 2 * d * d + e * e) / 2;
                        min = Math.min(min, s);
                    }
                }
            }
        }
        System.out.println(min);
    }
}
