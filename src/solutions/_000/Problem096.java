package solutions._000;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.StrictMath.max;

/**
 * Many algorithms exist to solve sudokus.
 * Inefficient implementation below.
 */
public class Problem096 {
    private static boolean check(int[][] a) {
        for (int i = 0; i < 9; i++) {
            int[] cnt = new int[10], cnt2 = new int[10];
            for (int j = 0; j < 9; j++) {
                cnt[a[i][j]]++;
                cnt2[a[j][i]]++;
            }
            for (int j = 1; j <= 9; j++) {
                if (cnt[j] > 1 || cnt2[j] > 1) {
                    return false;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int[] cnt = new int[10];
                for (int u = 3 * i; u < 3 * i + 3; u++) {
                    for (int v = 3 * j; v < 3 * j + 3; v++) {
                        cnt[a[u][v]]++;
                    }
                }
                for (int k = 1; k <= 9; k++) {
                    if (cnt[k] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static int[][] clone(int[][] a) {
        int[][] b = new int[10][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                b[i][j] = a[i][j];
            }
        }
        return b;
    }

    private static int solve(int[][] a) {
        // check legality
        if (!check(a)) {
            return -1;
        }
        // check if solved
        int ux = 0, uy = 0;
        boolean solved = true;
        out: for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (a[i][j] == 0) {
                    solved = false;
                    ux = i;
                    uy = j;
                    break out;
                }
            }
        }
        if (solved) {
            return 100 * a[0][0] + 10 * a[0][1] + a[0][2];
        }

        boolean[][][] b = new boolean[9][9][10]; // b[i][j][k] is true if a[i][j] cannot be k.
        // generate b
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (a[i][j] != 0) {
                    for (int u = 0; u < 9; u++) {
                        b[u][j][a[i][j]] = true;
                        b[i][u][a[i][j]] = true;
                    }
                    for (int u = 0; u < 3; u++) {
                        for (int v = 0; v < 3; v++) {
                            b[3 * (i / 3) + u][3 * (j / 3) + v][a[i][j]] = true;
                        }
                    }
                }
            }
        }

        boolean change = false;
        // find squares with only one possibility
        // also check at least one possibility exists
        for (int i = 0; i < 9; i++ ) {
            for (int j = 0; j < 9; j++) {
                if (a[i][j] == 0) {
                    int x = 0, cnt = 0;
                    for (int k = 1; k <= 9; k++) {
                        if (!b[i][j][k]) {
                            cnt++;
                            x = k;
                        }
                    }
                    if (cnt == 0) {
                        return -1;
                    }
                    if (cnt == 1) {
                        change = true;
                        a[i][j] = x;
                    }
                }
            }
        }
        // find values in row/column that fit in only one square
        for (int i = 0; i < 9; i++) {
            out: for (int k = 1; k <= 9; k++) {
                int x = 0, cnt = 0;
                for (int j = 0; j < 9; j++) {
                    if (a[i][j] == k) {
                        continue out;
                    }
                    if (!b[i][j][k]) {
                        cnt++;
                        x = j;
                    }
                }
                if (cnt == 0) {
                    return -1;
                }
                if (cnt == 1) {
                    change = true;
                    a[i][x] = k;
                }
            }
        }
        for (int j = 0; j < 9; j++) {
            out: for (int k = 1; k <= 9; k++) {
                int x = 0, cnt = 0;
                for (int i = 0; i < 9; i++) {
                    if (a[i][j] == k) {
                        continue out;
                    }
                    if (!b[i][j][k]) {
                        cnt++;
                        x = i;
                    }
                }
                if (cnt == 0) {
                    return -1;
                }
                if (cnt == 1) {
                    change = true;
                    a[x][j] = k;
                }
            }
        }
        // find values in 3x3 square that fit in only one square
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                out: for (int k = 1; k <= 9; k++) {
                    int x = 0, y = 0, cnt = 0;
                    for (int u = 3 * i; u < 3 * i + 3; u++) {
                        for (int v = 3 * j; v < 3 * j + 3; v++) {
                            if (a[u][v] == k) {
                                continue out;
                            }
                            if (!b[u][v][k]) {
                                cnt++;
                                x = u;
                                y = v;
                            }
                        }
                    }
                    if (cnt == 0) {
                        return -1;
                    }
                    if (cnt == 1) {
                        change = true;
                        a[x][y] = k;
                    }
                }
            }
        }

        // if any changes were made, run again
        if (change) {
            return solve(a);
        }
        // else, iterate over possibilities on an empty square
        int ans = -1;
        for (int k = 1; k <= 9; k++) {
            if (!b[ux][uy][k]) {
                int[][] c = clone(a);
                c[ux][uy] = k;
                ans = max(ans, solve(c));
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/resource/p096_sudoku.txt"));
        int ans = 0;
        int[][] a = new int[9][9];
        for (int i = 0; i < 50; i++) {
            br.readLine();
            for (int j = 0; j < 9; j++) {
                char[] line = br.readLine().toCharArray();
                for (int k = 0; k < 9; k++) {
                    a[j][k] = line[k] - '0';

                }
            }
            ans += solve(a);
        }
        System.out.println(ans);
    }
}
