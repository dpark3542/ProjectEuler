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
public class Problem083 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new FileReader("src/input/p083_matrix.txt"));
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
            for (int j = 0; j < n; j++) {
                if (i != 0 || j != 0) {
                    d[i][j] = Integer.MAX_VALUE;
                    pq.add(new Triple<>(i, j, d[i][j]));
                }
            }
        }
        d[0][0] = a[0][0];
        pq.add(new Triple<>(0, 0, d[0][0]));
        while (!pq.isEmpty()) {
            Triple<Integer, Integer, Integer> u = pq.poll();
            // left
            if (u.getSecond() - 1 >= 0) {
                int alt = d[u.getFirst()][u.getSecond()] + a[u.getFirst()][u.getSecond() - 1];
                if (alt < d[u.getFirst()][u.getSecond() - 1]) {
                    d[u.getFirst()][u.getSecond() - 1] = alt;
                    pq.add(new Triple<>(u.getFirst(), u.getSecond() - 1, alt));
                }
            }
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
        System.out.println(d[n - 1][n - 1]);
    }
}
