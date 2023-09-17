package solutions._000;

import utils.structs.BigFraction;
import utils.structs.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import static utils.Miscellaneous.rowReduce;

/**
 * Monopoly can be modeled as a Markov chain.
 * Create three states for each square, each state representing a different number of consecutive doubles.
 * Compute the steady state vector.
 *
 * Alternatively run simulations.
 */
public class Problem084 {
    private static final int n = 40;
    // squares
    private static final int GO = 0, A1 = 1, CC1 = 2, A2 = 3, T1 = 4, R1 = 5, B1 = 6, CH1 = 7, B2 = 8, B3 = 9;
    private static final int JAIL = 10, C1 = 11, U1 = 12, C2 = 13, C3 = 14, R2 = 15, D1 = 16, CC2 = 17, D2 = 18, D3 = 19;
    private static final int FP = 20, E1 = 21, CH2 = 22, E2 = 23, E3 = 24, R3 = 25, F1 = 26, F2 = 27, U2 = 28, F3 = 29;
    private static final int G2J = 30, G1 = 31, G2 = 32, CC3 = 33, G3 = 34, R4 = 35, CH3 = 36, H1 = 37, T2 = 38, H2 = 39;
    // probabilities for doubles and no doubles
    private static final Map<Integer, BigFraction> p = Map.of(
            3, new BigFraction(2, 16),
            4, new BigFraction(2, 16),
            5, new BigFraction(4, 16),
            6, new BigFraction(2, 16),
            7, new BigFraction(2, 16)
    ), q = Map.of(
            2, new BigFraction(1, 16),
            4, new BigFraction(1, 16),
            6, new BigFraction(1, 16),
            8, new BigFraction(1, 16)
    );

    /**
     * Returns probability array p where p[i][j] is the probability we land on square i with j number of doubles.
     * Handles all logic related to jail, community chest, and chance.
     *
     * @param x Intermediate square
     * @param l Number of doubles rolled
     * @return Probability array
     */
    private static BigFraction[][] process(int x, int l) {
        BigFraction[][] p = new BigFraction[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                p[i][j] = BigFraction.ZERO;
            }
        }
        if (x == G2J || l == 3) {
            p[JAIL][0] = BigFraction.ONE;
        }
        else if (x == CC1 || x == CC2 || x == CC3) {
            p[GO][l] = new BigFraction(1, 16);
            p[JAIL][0] = new BigFraction(1, 16);
            p[x][l] = new BigFraction(14, 16);
        }
        else if (x == CH1 || x == CH2 || x == CH3) {
            p[GO][l] = new BigFraction(1, 16);
            p[JAIL][0] = new BigFraction(1, 16);
            p[C1][l] = new BigFraction(1, 16);
            p[E3][l] = new BigFraction(1, 16);
            p[H2][l] = new BigFraction(1, 16);
            p[R1][l] = new BigFraction(1, 16);
            p[x][l] = new BigFraction(6, 16);
            if (x == CH1) {
                p[R2][l] = new BigFraction(2, 16);
                p[U1][l] = new BigFraction(1, 16);
                p[T1][l] = new BigFraction(1, 16);
            }
            else if (x == CH2) {
                p[R3][l] = new BigFraction(2, 16);
                p[U2][l] = new BigFraction(1, 16);
                p[D3][l] = new BigFraction(1, 16);
            }
            else {
                p[R1][l] = p[R1][l].add(new BigFraction(2, 16));
                p[U1][l] = new BigFraction(1, 16);
                p[CC3][l] = new BigFraction(14, 256);
                p[GO][l] = p[GO][l].add(new BigFraction(1, 256));
                p[JAIL][l] = p[JAIL][l].add(new BigFraction(1, 256));
            }
        }
        else {
            p[x][l] = BigFraction.ONE;
        }
        return p;
    }

    public static void main(String[] args) {
        // create transition matrix
        BigFraction[][] Q = new BigFraction[3 * n][3 * n];
        for (int i = 0; i < 3 * n; i++) {
            for (int j = 0; j < 3 * n; j++) {
                Q[i][j] = BigFraction.ZERO;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                int u = n * j  + i;
                // no doubles
                for (Entry<Integer, BigFraction> entry : p.entrySet()) {
                    int d = entry.getKey();
                    BigFraction pr = entry.getValue();
                    BigFraction[][] a = process((u + d) % n, 0);
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < 3; l++) {
                            Q[n * l + k][u] = Q[n * l + k][u].add(pr.multiply(a[k][l]));
                        }
                    }
                }
                // doubles
                for (Entry<Integer, BigFraction> entry : q.entrySet()) {
                    int d = entry.getKey();
                    BigFraction pr = entry.getValue();
                    BigFraction[][] a = process((u + d) % n, j + 1);
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < 3; l++) {
                            Q[n * l + k][u] = Q[n * l + k][u].add(pr.multiply(a[k][l]));
                        }
                    }
                }
            }
        }
        // compute steady state vector
        BigFraction x = new BigFraction(-1, 1);
        for (int i = 0; i < 3 * n; i++) {
            Q[i][i] = Q[i][i].add(x);
        }
        rowReduce(Q);
        Q[3 * n - 1][3 * n - 1] = BigFraction.ONE.negate();
        List<Pair<BigFraction, Integer>> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            BigFraction p = BigFraction.ZERO;
            for (int j = i; j < 3 * n; j += n) {
                p = p.add(Q[j][3 * n - 1]);
            }
            a.add(new Pair<>(p, i));
        }
        a.sort(Comparator.comparing(o -> o.first));
        for (int i = 0; i < 3; i++) {
            System.out.printf("%02d", a.get(i).second);
        }
    }
}
