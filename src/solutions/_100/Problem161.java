package solutions._100;

import utils.structs.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;

public class Problem161 {
    private static final int n = 12, m = 9, m_pow = (int) Math.pow(3, 9);
    private static final List<Integer> DOMAIN = new ArrayList<>();
    private static final Map<Integer, List<Pair<Integer, Integer>>> MAP = new HashMap<>();
    private static final List<BiPredicate<int[], Integer>> OPERATIONS = List.of(
            (a, i) -> {
                if (i + 1 >= m) {
                    return false;
                } else if (a[i + 1] != 1) {
                    return false;
                } else {
                    a[i] = 2;
                    a[i + 1] = 2;
                    return true;
                }
            },
            (a, i) -> {
                if (i - 1 < 0) {
                    return false;
                } else if (a[i - 1] != 1) {
                    return false;
                } else {
                    a[i - 1] = 2;
                    a[i] = 2;
                    return true;
                }
            },
            (a, i) -> {
                if (i + 1 >= m) {
                    return false;
                } else if (a[i + 1] != 0) {
                    return false;
                } else {
                    a[i] = 2;
                    a[i + 1] = 1;
                    return true;
                }
            },
            (a, i) -> {
                if (i + 1 >= m) {
                    return false;
                } else if (a[i + 1] != 0) {
                    return false;
                } else {
                    a[i] = 1;
                    a[i + 1] = 2;
                    return true;
                }
            },
            (a, i) -> {
                a[i] = 3;
                return true;
            },
            (a, i) -> {
                if (i + 2 >= m) {
                    return false;
                } else if (a[i + 1] != 0 || a[i + 2] != 0) {
                    return false;
                } else {
                    a[i] = 1;
                    a[i + 1] = 1;
                    a[i + 2] = 1;
                    return true;
                }
            },
            (a, i) -> {
                if (i + 2 >= m) {
                    return false;
                } else if (a[i + 1] != 0 || a[i + 2] != 0) {
                    return false;
                } else {
                    a[i] = 2;
                    a[i + 1] = 2;
                    a[i + 2] = 2;
                    return true;
                }
            },
            (a, i) -> {
                if (i + 3 >= m) {
                    return false;
                } else if (a[i + 1] != 0 || a[i + 2] != 0 || a[i + 3] != 0) {
                    return false;
                } else {
                    a[i] = 2;
                    a[i + 1] = 2;
                    a[i + 2] = 1;
                    a[i + 3] = 1;
                    return true;
                }
            }
    );
    public static void main(String[] args) {
        for (int i = 0; i < m_pow; i++) {
            int[] a = pushForward(i);

            boolean flag = false;
            int sum = 0;
            for (int j = 0; j < m; j++) {
                if (a[j] == 0) {
                    flag = true;
                }
                sum += a[j];
            }

            if (flag && sum % 3 == 0) {
                DOMAIN.add(i);
            }
        }

        for (int i : DOMAIN) {
            int[] a = pushForward(i);

            int j = 0;
            while (a[j] != 0) {
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
    
    private static List<Pair<Integer, Integer>> dfs(int[] a, int i) {
        if (i == m) {
            int min = 3;
            for (int j = 0; j < m; j++) {
                min = Math.min(min, a[j]);
            }

            int[] b = a.clone();
            for (int j = 0; j < m; j++) {
                b[j] -= min;
            }

            return List.of(new Pair<>(min, pullBack(b)));
        } else {
            List<Pair<Integer, Integer>> ans = new ArrayList<>();
            for (BiPredicate<int[], Integer> op : OPERATIONS) {
                int[] b = a.clone();
                if (op.test(b, i)) {
                    int j = i + 1;
                    while (j < m && b[j] != 0) {
                        j++;
                    }
                    ans.addAll(dfs(b, j));
                }
            }
            return ans;
        }
    }

    private static int[] pushForward(int x) {
        int[] a = new int[m];
        for (int i = 0; i < m && x > 0; i++) {
            a[i] = x % 3;
            x /= 3;
        }
        return a;
    }

    private static int pullBack(int[] a) {
        int x = 0;
        for (int i = 0; i < m; i++) {
            x = 3 * x + a[i];
        }
        return x;
    }
}
