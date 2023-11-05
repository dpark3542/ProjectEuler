package solutions._100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Breadth first search
 */
public class Problem122 {
    private static final int n = 200;

    public static void main(String[] args) {
        int ans = 0;
        int[] m = new int[n + 1];
        Deque<List<Integer>> q = new ArrayDeque<>();
        q.addLast(List.of(1));

        for (int cnt = 0, depth = 0; cnt < n; depth++) {
            Deque<List<Integer>> r = new ArrayDeque<>();
            while (!q.isEmpty()) {
                List<Integer> a = q.pollFirst();
                if (m[a.get(depth)] == 0) {
                    m[a.get(depth)] = depth;
                    ans += depth;
                    cnt++;
                }

                if (m[a.get(depth)] == depth) {
                    Set<Integer> s = new HashSet<>();
                    for (int i = 0; i < a.size(); i++) {
                        for (int j = i; j < a.size(); j++) {
                            int x = a.get(i) + a.get(j);
                            if (a.get(depth) < x && x <= n) {
                                s.add(a.get(i) + a.get(j));
                            }
                        }
                    }
                    for (int x : s) {
                        List<Integer> b = new ArrayList<>(a);
                        b.add(x);
                        r.addLast(b);
                    }
                }
            }
            q = r;
        }

        System.out.println(ans);
    }
}


