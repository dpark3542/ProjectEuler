package solutions._100;

import utils.structs.BigFraction;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static utils.structs.BigFraction.ONE;
import static utils.structs.BigFraction.ZERO;

/**
 * Counting line segment intersections is a well known problem usually done by line sweep.
 * For 5000 segments, brute force is sufficient and cleaner.
 */
public class Problem165 {
    private static final int n = 5000, a = 629527, b = 50515093, c = 500;

    public static void main(String[] args) {
        int[] s = new int[4 * n], t = new int[4 * n];
        s[0] = a;
        t[0] = a % c;
        for (int i = 1; i < 4 * n; i++) {
            s[i] = (int) (((long) s[i - 1] * s[i - 1]) % b);
            t[i] = s[i] % c;
        }

        Set<List<BigFraction>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                List<BigFraction> p = intersection(t[4 * i], t[4 * i + 1], t[4 * i + 2], t[4 * i + 3],
                                                   t[4 * j], t[4 * j + 1], t[4 * j + 2], t[4 * j + 3]);
                if (p != null) {
                    set.add(p);
                }
            }
        }
        System.out.println(set.size());
    }

    private static List<BigFraction> intersection(int ax, int ay, int bx, int by, int cx, int cy, int dx, int dy) {
        int bax = bx - ax, cdx = cx - dx, cax = cx - ax, bay = by - ay, cdy = cy - dy, cay = cy - ay, d = bax * cdy - bay * cdx;
        if (d == 0) {
            return null;
        }

        BigFraction s = new BigFraction(cax * cdy - cdx * cay, d), t = new BigFraction(bax * cay - cax * bay, d);
        if (ZERO.compareTo(s) < 0 && s.compareTo(ONE) < 0 && ZERO.compareTo(t) < 0 && t.compareTo(ONE) < 0) {
            return List.of(s.multiply(new BigFraction(bax)).add(new BigFraction(ax)),
                           s.multiply(new BigFraction(bay)).add(new BigFraction(ay)),
                           t.multiply(new BigFraction(-cdx)).add(new BigFraction(cx)),
                           t.multiply(new BigFraction(-cdy)).add(new BigFraction(cy)));
        }
        return null;
    }
}
