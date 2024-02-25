package solutions._000;

import static utils.Miscellaneous.generateNextPermutation;

/*
 * Brute force: test all permutations of numbers in the 5-gon ring.
 * A small optimization can be made forcing 10 to be an external node, else 10 will be repeated twice in the string and create a 17-digit string.
 * Implementation described below.
 *
 * Small optimization was not made to keep implementation simple.
 * a is the array containing the permutation of numbers.
 * External nodes in clockwise order are a[0], a[2], a[4], a[6], a[8].
 * Internal nodes in clockwise order are a[1], a[3], a[5], a[7], a[9].
 * a[0] is adjacent to a[1].
 */
public class Problem068 {
    public static void main(String[] args) {
        String max = ""; // max string
        int[] a = new int[10]; // array for permutation
        for (int i = 0; i < 10; i++) {
            a[i] = i + 1;
        }
        // iterate through all permutations
        while (true) {
            boolean flag = true; // flag if magic ring found
            int sum = a[0] + a[1] + a[3]; // sum of first group of 3
            // verify if ring is magic
            for (int j = 2; j <= 8; j += 2) {
                if (a[j] + a[j + 1] + a[(j + 3) % 10] != sum) {
                    flag = false;
                    break;
                }
            }
            // if ring is magic, compare to max string
            if (flag) {
                StringBuilder sb = new StringBuilder();
                // find minimum leaf
                int j = 0;
                for (int k = 2; k <= 8; k += 2) {
                    if (a[k] < a[j]) {
                        j = k;
                    }
                }
                // generate string
                for (int k = j; k < j + 10; k += 2) {
                    sb.append(a[k % 10]);
                    sb.append(a[(k + 1) % 10]);
                    sb.append(a[(k + 3) % 10]);
                }
                // compare string
                if (sb.length() == 16 && sb.toString().compareTo(max) > 0) {
                    max = sb.toString();
                }
            }
            if (!generateNextPermutation(a)) {
                break;
            }
        }
        System.out.println(max);
    }
}
