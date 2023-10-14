package solutions._000;

import utils.structs.Triple;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Dijkstra's algorithm.
 */
public class Problem082 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new FileReader("src/resource/p082_matrix.txt"));
        int n = 80;
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(",");
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(split[j]);
            }
        }

        int[][] d = new int[n][n];
        PriorityQueue<Triple<Integer, Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparing(Triple::getThird));
        for (int i = 0; i < n; i++) {
            d[i][0] = a[i][0];
            pq.add(new Triple<>(i, 0, d[i][0]));
            for (int j = 1; j < n; j++) {
                d[i][j] = Integer.MAX_VALUE;
                pq.add(new Triple<>(i, j, d[i][j]));
            }
        }
        while (!pq.isEmpty()) {
            Triple<Integer, Integer, Integer> u = pq.poll();
            // right
            if (u.getSecond() + 1 < n) {
                int alt = d[u.getFirst()][u.getSecond()] + a[u.getFirst()][u.getSecond() + 1];
                if (alt < d[u.getFirst()][u.getSecond() + 1]) {
                    d[u.getFirst()][u.getSecond() + 1] = alt;
                    pq.add(new Triple<>(u.getFirst(), u.getSecond() + 1, alt));
                }
            }
            // up
            if (u.getFirst() - 1 >= 0) {
                int alt = d[u.getFirst()][u.getSecond()] + a[u.getFirst() - 1][u.getSecond()];
                if (alt < d[u.getFirst() - 1][u.getSecond()]) {
                    d[u.getFirst() - 1][u.getSecond()] = alt;
                    pq.add(new Triple<>(u.getFirst() - 1, u.getSecond(), alt));
                }
            }
            // down
            if (u.getFirst() + 1 < n) {
                int alt = d[u.getFirst()][u.getSecond()] + a[u.getFirst() + 1][u.getSecond()];
                if (alt < d[u.getFirst() + 1][u.getSecond()]) {
                    d[u.getFirst() + 1][u.getSecond()] = alt;
                    pq.add(new Triple<>(u.getFirst() + 1, u.getSecond(), alt));
                }
            }
        }
        int ans = d[0][n - 1];
        for (int i = 1; i < n; i++) {
            ans = Math.min(ans, d[i][n - 1]);
        }
        System.out.println(ans);
    }
}
