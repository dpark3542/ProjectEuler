package solutions._100;

import utils.structs.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem124 {
    private static final int n = 100000;
    private static final int i = 10000;

    public static void main(String[] args) {
        List<Pair<Integer, Integer>> e = new ArrayList<>();
        for (int j = 1; j <= n; j++) {
            e.add(new Pair<>(rad(j), j));
        }
        e.sort(Comparator.comparing(Pair::first));
        System.out.println(e.get(i - 1).second());
    }

    private static int rad(int n) {
        int x = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                x *= i;
            }
            while (n % i == 0) {
                n /= i;
            }
        }
        return x * n;
    }
}
