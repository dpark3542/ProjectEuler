package solutions.java;

/*
 * Created by dpark3542 on 5/7/2017.
 */
public class Problem016 {
    /*
     * Bignum multiplication:
     * Compute successive powers of 2.
     * For each power of 2, multiply 2 to each digit and carry over to get the next power of 2.
     * Bignum operations are already implemented in Java's BigInteger class.
     *
     */
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("1");
        for (int i = 0; i < 1000; i++) {
            StringBuilder sb2 = new StringBuilder();
            int c = 0;
            for (int j = 0; j < sb.length() || c > 0; j++) {
                int d = 0;
                if (j < sb.length()) {
                    d = Integer.parseInt(sb.substring(j, j + 1));
                }
                sb2.append((2 * d + c) % 10);
                c = (2 * d + c) / 10;
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
