package solutions._000;

import utils.structs.Triple;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.Integer.parseInt;

/**
 * Brute force.
 * Upper bound is 30 since password of 0123456789 repeated three times satisfies all keylogs.
 * Upper bound is achieved for 000, 111, ..., 999.
 */
public class Problem079 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new FileReader("src/resource/p079_keylog.txt"));
        Set<Integer> s = new HashSet<>();
        Set<Triple<Integer, Integer, Integer>> t = new HashSet<>();
        while (br.ready()) {
            int x = parseInt(br.readLine());
            t.add(new Triple<>(x / 100, (x / 10) % 10, x % 10));
            s.add(x / 100);
            s.add((x / 10) % 10);
            s.add(x % 10);
        }

        Deque<List<Integer>> a = new ArrayDeque<>();
        for (int x : s) {
            a.addLast(List.of(x));
        }

        while (true) {
            int n = a.size();
            for (int i = 0; i < n; i++) {
                List<Integer> b = a.pollFirst();
                for (int x : s) {
                    List<Integer> c = new ArrayList<>(b);
                    c.add(x);

                    if (c.size() >= s.size() && isLeaf(c, t)) {
                        for (int y : c) {
                            System.out.print(y);
                        }
                        System.out.println();
                        return;
                    }

                    a.addLast(c);
                }
            }
        }
    }

    private static boolean isLeaf(List<Integer> a, Set<Triple<Integer, Integer, Integer>> s) {
        Set<Triple<Integer, Integer, Integer>> t = new HashSet<>(s.size());
        for (int i = 0; i < a.size(); i++) {
            for (int j = i + 1; j < a.size(); j++) {
                for (int k = j + 1; k < a.size(); k++) {
                    if (s.contains(new Triple<>(a.get(i), a.get(j), a.get(k)))) {
                        t.add(new Triple<>(a.get(i), a.get(j), a.get(k)));
                    }
                    if (s.size() == t.size()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
