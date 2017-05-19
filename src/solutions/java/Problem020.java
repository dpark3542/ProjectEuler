package solutions.java;

/*
 * Created by dpark3542 on 5/10/2017.
 */
public class Problem020 {
    /*
     * Bignum multiplication:
     * Compute successive factorials.
     * For each factorial, multiply each digit by the next number and carry over to get the next factorial.
     * Alternate factorial computation algorithms exist such as prime factorization.
     * Bignum operations are already implemented in Java's BigInteger class.
     *
     */
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("1");
        for (int i = 1; i <= 100; i++) {
            StringBuilder sb2 = new StringBuilder();
            int c = 0;
            for (int j = 0; j < sb.length() || c > 0; j++) {
                int d = 0;
                if (j < sb.length()) {
                    d = Integer.parseInt(sb.substring(j, j + 1));
                }
                sb2.append((i * d + c) % 10);
                c = (i * d + c) / 10;
            }
            sb = sb2;
        }
        int sum = 0;
        for (int i = 0; i < sb.length(); i++) {
            sum += Integer.parseInt(sb.substring(i, i + 1));
        }
        System.out.println(sum);
    }
}
