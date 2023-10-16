package solutions._100;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem105 {
    private static final int m = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/resource/p105_sets.txt"));
        int sum = 0;
        for (int i = 0; i < m; i++) {
            List<Integer> a = new ArrayList<>();
            for (String s : br.readLine().split(",")) {
                a.add(Integer.parseInt(s));
            }
            Collections.sort(a);
            if (isSpecial(a)) {
                for (int x : a) {
                    sum += x;
                }
            }
        }
        System.out.println(sum);
    }

    public static boolean isSpecial(List<Integer> a) {
        for (int i = 1; 2 * i + 1 <= a.size(); i++) {
            int x = 0;
            for (int j = 0; j < i + 1; j++) {
                x += a.get(j);
            }

            int y = 0;
            for (int j = 0; j < i; j++) {
                y += a.get(a.size() - j - 1);
            }

            if (x < y) {
                return false;
            }
        }

        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < Math.pow(2, a.size()); i++) {
            int tot = 0;
            for (int j = 0, k = i; k > 0; k >>= 1, j++) {
                if ((k & 1) == 1) {
                    tot += a.get(j);
                }
            }
            if (s.contains(tot)) {
                return false;
            }
            s.add(tot);
        }

        return true;
    }
}
