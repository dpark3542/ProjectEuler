package solutions._100;

import utils.structs.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;

import static java.lang.StrictMath.min;
import static utils.NumberTheory.fromBase;
import static utils.NumberTheory.toBase;

public class Problem161 {
    private static final int n = 12, m = 9, m_pow = 19683;
    private static final List<Integer> DOMAIN = new ArrayList<>();
    private static final Map<Integer, List<Pair<Integer, Integer>>> MAP = new HashMap<>();
    private static final List<BiPredicate<List<Integer>, Integer>> OPERATIONS = List.of(
            (a, i) -> {
                if (i + 1 >= m) {
                    return false;
                } else if (a.get(i + 1) != 1) {
                    return false;
                } else {
                    a.set(i, 2);
                    a.set(i + 1, 2);
                    return true;
                }
            },
            (a, i) -> {
                if (i - 1 < 0) {
                    return false;
                } else if (a.get(i - 1) != 1) {
                    return false;
                } else {
                    a.set(i - 1, 2);
                    a.set(i, 2);
                    return true;
                }
            },
            (a, i) -> {
                if (i + 1 >= m) {
                    return false;
                } else if (a.get(i + 1) != 0) {
                    return false;
                } else {
                    a.set(i, 2);
                    a.set(i + 1, 1);
                    return true;
                }
            },
            (a, i) -> {
                if (i + 1 >= m) {
                    return false;
                } else if (a.get(i + 1) != 0) {
                    return false;
                } else {
                    a.set(i, 1);
                    a.set(i + 1, 2);
                    return true;
                }
            },
            (a, i) -> {
                a.set(i, 3);
                return true;
            },
            (a, i) -> {
                if (i + 2 >= m) {
                    return false;
                } else if (a.get(i + 1) != 0 || a.get(i + 2) != 0) {
                    return false;
                } else {
                    a.set(i, 1);
                    a.set(i + 1, 1);
                    a.set(i + 2, 1);
                    return true;
                }
            },
            (a, i) -> {
                if (i + 2 >= m) {
                    return false;
                } else if (a.get(i + 1) != 0 || a.get(i + 2) != 0) {
                    return false;
                } else {
                    a.set(i, 2);
                    a.set(i + 1, 2);
                    a.set(i + 2, 2);
                    return true;
                }
            },
            (a, i) -> {
                if (i + 3 >= m) {
                    return false;
                } else if (a.get(i + 1) != 0 || a.get(i + 2) != 0 || a.get(i + 3) != 0) {
                    return false;
                } else {
                    a.set(i, 2);
                    a.set(i + 1, 2);
                    a.set(i + 2, 1);
                    a.set(i + 3, 1);
                    return true;
                }
            }
    );

    public static void main(String[] args) {
        for (int i = 0; i < m_pow; i++) {
            List<Integer> a = toBase(i, 3);

            boolean flag = a.size() < m;
            int sum = 0;
            for (int x : a) {
                if (x == 0) {
                    flag = true;
                }
                sum += x;
            }

            if (flag && sum % 3 == 0) {
                DOMAIN.add(i);
            }
        }

        for (int i : DOMAIN) {
            List<Integer> a = toBase(i, 3, m);
            int j = 0;
            while (a.get(j) != 0) {
                j++;
            }

            MAP.put(i, dfs(a, j));
        }

        long[][] dp = new long[n + 3][m_pow];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j : DOMAIN) {
                for (Pair<Integer, Integer> p : MAP.get(j)) {
                    dp[i + p.first()][p.second()] += dp[i][j];
                }
            }
        }

        System.out.println(dp[n][0]);
    }
    
    private static List<Pair<Integer, Integer>> dfs(List<Integer> a, int i) {
        if (i == m) {
            int min = 3;
            for (int j = 0; j < m; j++) {
                min = min(min, a.get(j));
            }

            List<Integer> b = new ArrayList<>(m);
            for (int j = 0; j < m; j++) {
                b.add(a.get(j) - min);
            }

            return List.of(new Pair<>(min, (int) fromBase(b, 3)));
        } else {
            List<Pair<Integer, Integer>> ans = new ArrayList<>();
            for (BiPredicate<List<Integer>, Integer> op : OPERATIONS) {
                List<Integer> b = new ArrayList<>(a);
                if (op.test(b, i)) {
                    int j = i + 1;
                    while (j < m && b.get(j) != 0) {
                        j++;
                    }
                    ans.addAll(dfs(b, j));
                }
            }
            return ans;
        }
    }
}
