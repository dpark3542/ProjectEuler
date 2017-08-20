package solutions.java;

public class Problem009 {
    /*
     * Brute force: loop through all possible c and b, a can be determined using a = 1000 - b - c and test if a^2 + b^2
     * = c^2.
     *
     * Alternatively, a^2 + b^2 = c^2 = (1000-a-b)^2 which reduces to 2ab - 2000a - 2000b + 1000^2 = 0 which can be
     * solved using Simon's Favorite Factoring Trick.
     */
    public static void main(String[] args) {
        out:
        for (int c = 1; c < 1000; c++) {
            for (int b = (1000 - c) / 2; b < c; b++) {
                if ((1000 - b - c) * (1000 - b - c) + b * b == c * c) {
                    System.out.println((1000 - b - c) * b * c);
                    break out;
                }
            }
        }
    }
}
