package solutions._100;

import utils.structs.Pair;

public class Problem144 {
    private static final Pair<Double, Double> a = new Pair<>(0.0, 10.1), b = new Pair<>(1.4, -9.6);
    private static final double r = 0.01;

    public static void main(String[] args) {
        int ans = 0;
        Pair<Double, Double> p = a, q = b;
        while (!(q.second() > 0 && -r < q.first() && q.first() < r)) {
            double n = -4 * q.first() / q.second(), dx = q.first() - p.first(), dy = q.second() - p.second();
            double m = (2 * dx * n - dy * (1 - n * n)) / (dx * (1 - n * n) + 2 * dy * n);
            double x = 2 * m * (m * q.first() - q.second()) / (m * m + 4) - q.first();
            double y = m * (x - q.first()) + q.second();

            p = q;
            q = new Pair<>(x, y);

            ans++;
        }
        System.out.println(ans);
    }
}
