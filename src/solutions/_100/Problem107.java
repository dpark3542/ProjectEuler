package solutions._100;

import utils.structs.Triple;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Minimum spanning tree is well known.
 * Kruskal's algorithm is implemented below without disjoint set union.
 */
public class Problem107 {
    private static final int n = 40;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/resource/p107_network.txt"));

        int ans = 0;
        List<Triple<Integer, Integer, Integer>> a = new ArrayList<>();
        for (int u = 0; u < n; u++) {
            String[] line = br.readLine().split(",");
            for (int v = 0; v < u; v++) {
                if (!line[v].equals("-")) {
                    int w = Integer.parseInt(line[v]);
                    ans += w;
                    a.add(new Triple<>(w, u, v));
                }
            }
        }

        a.sort(Comparator.comparing(Triple::first));

        int[] dsu = new int[n];
        int cc = 0, cnt = 0;
        for (Triple<Integer, Integer, Integer> t : a) {
            int u = t.second(), v = t.third();
            if (dsu[u] != 0 && dsu[u] == dsu[v]) {
                continue;
            }

            ans -= t.first();
            cnt++;
            if (cnt == n - 1) {
                break;
            }

            if (dsu[u] == 0 && dsu[v] == 0) {
                cc++;
                dsu[u] = cc;
                dsu[v] = cc;
            } else if (dsu[u] == 0) {
                dsu[u] = dsu[v];
            } else if (dsu[v] == 0) {
                dsu[v] = dsu[u];
            } else {
                int tmp = dsu[v];
                for (int i = 0; i < n; i++) {
                    if (dsu[i] == tmp) {
                        dsu[i] = dsu[u];
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
