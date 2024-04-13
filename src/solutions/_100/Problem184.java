package solutions._100;

import utils.structs.BigFraction;
import utils.structs.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import static utils.structs.BigFraction.ZERO;

public class Problem184 {
    private static final int n = 105;
    private static final Pair<Integer, BigFraction> u = new Pair<>(3, ZERO);

    public static void main(String[] args) {
        Comparator<Pair<Integer, BigFraction>> comp = Comparator.comparing((Pair<Integer, BigFraction> p) -> p.first())
                                                                .thenComparing(Pair::second);
        NavigableMap<Pair<Integer, BigFraction>, Integer> map = new TreeMap<>(comp);
        for (int i = 1; i < n; i++) {
            for (int j = 0; i * i + j * j < n * n; j++) {
                BigFraction f = new BigFraction(j, i);
                for (int k = 1; k <= 4; k++) {
                    map.put(new Pair<>(k, f), map.getOrDefault(new Pair<>(k, f), 0) + 1);
                }
            }
        }

        Map<Pair<Integer, BigFraction>, Integer> dp = new HashMap<>();
        int sum = 0;
        for (Map.Entry<Pair<Integer, BigFraction>, Integer> entry : map.headMap(u, true).entrySet()) {
            sum += entry.getValue();
            dp.put(entry.getKey(), sum);
        }

        long ans = 0;
        int v = dp.get(u) - map.get(u);
        for (Map.Entry<Pair<Integer, BigFraction>, Integer> a : map.headMap(u, false).entrySet()) {
            int c = dp.get(a.getKey());
            for (Map.Entry<Pair<Integer, BigFraction>, Integer> b : map.subMap(a.getKey(), false, new Pair<>(a.getKey().first() + 2, a.getKey().second()), false).entrySet()) {
                ans += a.getValue() * b.getValue() * ((comp.compare(b.getKey(), u) < 0 ? dp.get(b.getKey()) - b.getValue() : v) - c);
            }
        }
        System.out.println(ans);
    }
}
