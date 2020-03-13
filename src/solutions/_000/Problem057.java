package solutions._000;

/*
 * Brute force: test every expansion.
 * Bignums are necessary for this approach.
 *
 * Alternatively, obtain a recurrence for each expansion.
 * Let p_i/q_i be the ith convergent. We will prove both the numerator and denominator have recurrences a_n = 2a_(n-1) + a_(n-2).
 * See problem 65 where the recurrences are generalized for any continued fraction.
 *
 * Proof:
 * The convergents satisfy the recurrence,
 * p_(i+1)/q_(i+1) = 1 + 1/(1 + p_i/q_i) = (p_i + 2q_i)/(p_i + q_i)
 * And gcd(p_i + 2q_i, p_i + q_i) = gcd(p_i, q_i) = 1.
 * Thus the right hand side is simplified.
 * Then matching the numerator and denominator of both sides gives the recurrence relations,
 * p_(i+1) = p_i + 2q_i
 * q_(i+1) = p_i + q_i
 * Solving for q_i in the first equation gives,
 * q_i = (p_(i+1) - p_i) / 2
 * Substituting in the second equations gives q in terms of p,
 * q_(i+1) = p_i + (p_(i+1) - p_i) / 2 = (p_(i+1) + p_i) / 2
 * Substituting into the first equation gives the recurrence relation for p,
 * p_(i+1) = 2p_i + p_(i-1)
 * Similarly, a recurrence relation for q can be derived.
 * Thus the expansions can be efficiently calculated using dynamic programming with the recurrence relations above.
 *
 * The solution can be further optimized.
 * Solve this linear recurrence for the initial terms,
 * p_i = (1.5+sqrt(2)) * (1+sqrt(2))^i + (1.5-sqrt(2)) * (1-sqrt(2))^i
 * q_i = (1+0.75sqrt(2)) * (1+sqrt(2))^i + (1-0.75sqrt(2)) * (1-sqrt(2))^i
 * Notice the second term of each formula decreases and tends towards zero as i increases.
 * Testing the first few expansions confirms the second term is effectively zero.
 * Thus we only have to compare the first terms after applying log base 10 and floor.
 *
 */
public class Problem057 {
    public static void main(String[] args) {
        int cnt = 0;
        double a = Math.log10(1 + Math.sqrt(2)), b = Math.log10(1.5 + Math.sqrt(2)), c = Math.log10(1 + 0.75 * Math.sqrt(2));
        for (int i = 0; i < 1000; i++) {
            if (Math.floor(b + i * a) > Math.floor(c + i * a)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
