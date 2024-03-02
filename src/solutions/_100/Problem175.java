package solutions._100;

import java.util.ArrayList;
import java.util.List;

import static utils.NumberTheory.gcd;

/**
 * From Problem 169, $f$ can be defined recursively based on the parity of $n$.
 * Using $\gcd(a,b)=\gcd(a,a-b)$, it is easy to see $\gcd(f(n),f(n-1))=1$.
 * Then we know $f(n)$ and $f(n-1)$.
 *
 * Also easy to see $f(n)>f(n-1)$ if and only if $n$ is even.
 * Solving for $f(n),f(n-1)$ reduces to solving for $f(\lfloor n/2 \rfloor),f(\lfloor n/2 \rfloor-1)$.
 * This lets us iteratively build up the binary expansion of $n$.
 * Since the reduction is a subtraction, we can directly calculate the shortened binary expansion with a Euclidean algorithm.
 *
 * For the final iteration, notice $f(n)=1$ if and only if $n=2^m-1$ for some $m$.
 * Also $f(2^m-2)=m$ and $f(2^m)=m+1$.
 */
public class Problem175 {
    private static final int n = 123456789, d = 987654321;

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        int g = (int) gcd(n, d), x = n / g, y = d / g;
        while (x > 1 && y > 1) {
            if (x < y) {
                a.add(y / x);
                y %= x;
            } else {
                a.add(x / y);
                x %= y;
            }
        }

        if (x == 1) {
            a.add(y);
        } else {
            a.add(x - 1);
            a.add(1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = a.size() - 1; i >= 1; i--) {
            sb.append(a.get(i));
            sb.append(',');
        }
        sb.append(a.getFirst());

        System.out.println(sb);
    }
}