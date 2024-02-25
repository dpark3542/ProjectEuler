package solutions._000;

import static java.lang.Integer.parseInt;

/*
 * Bignum multiplication:
 * Compute successive powers of 2.
 * For each power of 2, multiply 2 to each digit and carry over to get the next power of 2.
 * Bignum operations are already implemented in Java's BigInteger class.
 */
public class Problem016 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("1");
        for (int i = 0; i < 1000; i++) {
            StringBuilder sb2 = new StringBuilder();
            int c = 0;
            for (int j = 0; j < sb.length() || c > 0; j++) {
                int d = 0;
                if (j < sb.length()) {
                    d = parseInt(sb.substring(j, j + 1));
                }
                sb2.append((2 * d + c) % 10);
                c = (2 * d + c) / 10;
            }
            sb = sb2;
        }
        int sum = 0;
        for (int i = 0; i < sb.length(); i++) {
            sum += parseInt(sb.substring(i, i + 1));
        }
        System.out.println(sum);
    }
}
