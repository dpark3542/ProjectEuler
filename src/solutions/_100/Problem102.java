package solutions._100;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The orientation of three points $(a, b), (c, d), (e, f)$ is well-known to be
 * \[\begin{vmatrix}
 *     a & b & 1\\
 *     c & d & 1\\
 *     e & f & 1
 * \end{vmatrix}.\]
 * Check if the orientation of each pair of points with respect to the origin is constant.
 *
 */
public class Problem102 {
    private static final int n = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/resource/p102_triangles.txt"));
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(",");
            int[] a = new int[6];
            for (int j = 0; j < 6; j++) {
                a[j] = Integer.parseInt(line[j]);
            }
            int o = Integer.compare(a[0] * a[3] - a[1] * a[2], 0);
            int p = Integer.compare(a[2] * a[5] - a[3] * a[4], 0);
            int q = Integer.compare(a[1] * a[4] - a[0] * a[5], 0);
            if (o != 0 && o == p && p == q) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
