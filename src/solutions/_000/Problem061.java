package solutions._000;

import java.util.*;

public class Problem061 {
    public static void main(String[] args) {
        List<Map<Integer, List<Integer>>> a = new ArrayList<>(), b = new ArrayList<>();
        for (int s = 0; s <= 8; s++) {
            a.add(new HashMap<>());
            b.add(new HashMap<>());
        }
        for (int s = 3; s <= 8; s++) {
            for (int n = 1, p = 1; p <= 9999; n++, p = polygonal(s, n)) {
                if (1000 <= p) {
                    int x = p / 100, y = p % 100;
                    if (a.get(s).containsKey(x)) {
                        a.get(s).get(x).add(p);
                    }
                    else {
                        List<Integer> l = new ArrayList<>();
                        l.add(p);
                        a.get(s).put(x, l);
                    }
                    if (b.get(s).containsKey(y)) {
                        b.get(s).get(y).add(p);
                    }
                    else {
                        List<Integer> l = new ArrayList<>();
                        l.add(p);
                        b.get(s).put(y, l);
                    }
                }
            }
        }
        int[] c = {4, 5, 6, 7, 8};
        while (true) {
            Deque<List<Integer>> q = new ArrayDeque<>();
            for (List<Integer> l : b.get(3).values()) {
                for (int p : l) {
                    List<Integer> m = new ArrayList<>();
                    m.add(p);
                    q.addFirst(m);
                }
            }
            for (int s : c) {
                int len = q.size();
                for (int i = 0; i < len; i++) {
                    List<Integer> m = q.pollLast();
                    int x = m.get(m.size() - 1) % 100;
                    if (!a.get(s).containsKey(x)) {
                        continue;
                    }
                    for (int p : a.get(s).get(x)) {
                        List<Integer> k = new ArrayList<>(m);
                        k.add(p);
                        q.addFirst(k);
                    }
                }
            }
            for (List<Integer> l : q) {
                if (l.get(l.size() - 1) % 100 == l.get(0) / 100) {
                    int sum = 0;
                    for (int e : l) {
                        sum += e;
                    }
                    System.out.println(sum);
                    return;
                }
            }
            c = generateNextPermutation(c);
        }
    }

    private static int polygonal(int s, int n) {
        return (n * n * (s - 2) - n * (s - 4)) / 2;
    }

    private static int[] generateNextPermutation(int[] a) {
        int n = a.length, k = n - 2;
        while (k >= 0 && a[k] >= a[k + 1]) {
            k--;
        }
        if (k < 0) {
            return a;
        }
        int l = n - 1;
        while (a[k] >= a[l]) {
            l--;
        }
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        for (int i = k + 1; i <= (k + n - 1) / 2; i++) {
            t = a[n - i + k];
            a[n - i + k] = a[i];
            a[i] = t;
        }
        return a;
    }
}
