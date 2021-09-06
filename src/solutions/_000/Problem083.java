package solutions._000;

import utils.DataStructures.Triple;

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

        int d[][] = new int[n][n];
        PriorityQueue<Triple<Integer, Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparing(o -> o.third));
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
            if (u.second - 1 >= 0) {
                int alt = d[u.first][u.second] + a[u.first][u.second - 1];
                if (alt < d[u.first][u.second - 1]) {
                    d[u.first][u.second - 1] = alt;
                    pq.add(new Triple<>(u.first, u.second - 1, alt));
                }
            }
            // right
            if (u.second + 1 < n) {
                int alt = d[u.first][u.second] + a[u.first][u.second + 1];
                if (alt < d[u.first][u.second + 1]) {
                    d[u.first][u.second + 1] = alt;
                    pq.add(new Triple<>(u.first, u.second + 1, alt));
                }
            }
            // up
            if (u.first - 1 >= 0) {
                int alt = d[u.first][u.second] + a[u.first - 1][u.second];
                if (alt < d[u.first - 1][u.second]) {
                    d[u.first - 1][u.second] = alt;
                    pq.add(new Triple<>(u.first - 1, u.second, alt));
                }
            }
            // down
            if (u.first + 1 < n) {
                int alt = d[u.first][u.second] + a[u.first + 1][u.second];
                if (alt < d[u.first + 1][u.second]) {
                    d[u.first + 1][u.second] = alt;
                    pq.add(new Triple<>(u.first + 1, u.second, alt));
                }
            }
        }
        System.out.println(d[n - 1][n - 1]);
    }
}
