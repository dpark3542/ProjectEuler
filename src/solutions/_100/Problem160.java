package solutions._100;

import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import static utils.NumberTheory.legendre;
import static utils.NumberTheory.powerMod;


/**
 * Let $n=10^{12}$ and $m=10^5$. Define $f:[1,n]\to [1,n]$ by
 * \[f(x)=\dfrac{x}{2^{v_2(x)}5^{v_5(x)}}.\]
 * The answer is
 * \[\dfrac{n!}{2^{v_5(n!)}5^{v_5(n!)}} \cong 2^{v_2(n!)-v_5(n!)}f(n!).\]
 * Since $f$ is multiplicative,
 * \begin{align*}
 *     &\cong 2^{v_2(n!)-v_5(n!)}\prod_{i=1}^n f(i) \\
 *     &\cong 2^{v_2(n!)-v_5(n!)}\prod_{j \in \im f} j^{|f^{-1}(j)|}.
 * \end{align*}
 * $v_p(n!)$ can be computed quickly with Legendre's formula. Powers mod $m$ can be also computed quickly with successive squaring. Taking the product over all $j\in \im f$ is too slow, however. Let $g(x) = f(x) \pmod{m}$.
 * \begin{align*}
 *     &\cong 2^{v_2(n!)-v_5(n!)}\prod_{j \in \im g} j^{|g^{-1}(j)|}.
 * \end{align*}
 * To compute $|g^{-1}(x)|$ efficiently, first notice
 * \[h(x):=|f^{-1}(x)|=\lvert\{(a,b) \in (\Z^+)^2 \mid x2^a5^b \leq n\}\rvert.\]
 * is monotone decreasing. Moreover, the number of times $h$ strictly decreases is bounded by
 * \[|h(1)| \leq (\log_2n+1)(\log_5n+1).\]
 * We can easily represent $h$ with an accumulated array even though $n$ is large. We can also compute $h^{-1}(x)$ easily with binary search. Finally,
 * \[|g^{-1}(x)|=\sum_{y\in \im h} y\lvert h^{-1}(y) \cap (m\Z + x)\rvert.\]
 */
public class Problem160 {
    private static final long LIMIT = 1000000000000L;
    private static final int MOD = 100000;


    public static void main(String[] args) {
        NavigableMap<Long, Integer> a = new TreeMap<>(Comparator.reverseOrder()), h = new TreeMap<>();
        for (long x = 1; x <= LIMIT; x *= 2) {
            for (long y = 1; x * y <= LIMIT; y *= 5) {
                long key = LIMIT / (x * y);
                a.put(key, a.getOrDefault(key, 0) + 1);
            }
        }

        int sum = 0;
        for (Map.Entry<Long, Integer> entry : a.entrySet()) {
            sum += entry.getValue();
            h.put(entry.getKey(), sum);
        }

        long ans = powerMod(2, legendre(2, LIMIT) - legendre(5, LIMIT), MOD);
        for (int j = 3; j < MOD; j += 2) {
            if (j % 5 == 0) {
                continue;
            }

            long j_mod = j, e = 0;
            while (j_mod < LIMIT) {
                Map.Entry<Long, Integer> entry = h.ceilingEntry(j_mod);

                long j_new = entry.getKey() - entry.getKey() % MOD + j;
                if (entry.getKey() % MOD >= j) {
                    j_new += MOD;
                }

                e += entry.getValue() * (j_new - j_mod) / MOD;

                j_mod = j_new;
            }
            ans = (ans * powerMod(j, e, MOD)) % MOD;
        }
        System.out.println(ans);
    }
}
