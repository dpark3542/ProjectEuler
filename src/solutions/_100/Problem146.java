package solutions._100;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static utils.NumberTheory.crt;
import static utils.NumberTheory.isPrime;

public class Problem146 {
    private static final int n = 150000000, m = 10, c = 5;
    private static final List<Integer> a = List.of(1, 3, 7, 9, 13, 27);

    public static void main(String[] args) {
        Set<Integer> small = new HashSet<>();
        List<Long> primes = new ArrayList<>();
        List<List<Long>> residues = new ArrayList<>();
        primes.add(2L);
        residues.add(List.of(0L));

        for (int prime = 3; residues.size() < m; prime += 2) {
            if (isPrime(prime)) {
                primes.add((long) prime);

                List<Long> r = new ArrayList<>();
                out: for (int i = 0; i <= (prime - 1) / 2; i++) {
                    for (int j : a) {
                        if ((i * i + j) % prime == 0) {
                            if (i * i + j == prime) {
                                small.add(i);
                            }
                            continue out;
                        }
                    }

                    r.add((long) i);
                    if (i != 0) {
                        r.add((long) (prime - i));
                    }
                }
                residues.add(r);
            }
        }

        long ans = 0;
        for (int x : small) {
            if (check(x)) {
                ans += x;
            }
        }
        for (List<Long> s : tuples(residues, new ArrayList<>(), 0)) {
            long x = crt(s, primes);

            if (check(x)) {
                ans += x;
            }
        }
        System.out.println(ans);
    }

    private static boolean check(long x) {
        if (x <= 0 || x >= n) {
            return false;
        }

        for (int i = 1; i <= a.getLast(); i += 2) {
            if (BigInteger.valueOf(x * x + i).isProbablePrime(c) != a.contains(i)) {
                return false;
            }
        }

        return true;
    }

    private static List<List<Long>> tuples(List<List<Long>> s, List<Long> t, int i) {
        if (i == s.size()) {
            return List.of(t);
        }

        List<List<Long>> ans = new ArrayList<>();
        for (long x : s.get(i)) {
            List<Long> tt = new ArrayList<>(t);
            tt.add(x);
            ans.addAll(tuples(s, tt, i + 1));
        }
        return ans;
    }
}
