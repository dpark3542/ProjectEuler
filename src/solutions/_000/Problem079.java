package solutions._000;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static utils.Miscellaneous.generateNextPermutation;

/**
 * Inspection of the text file suggests the passcode is simple and may not repeat digits.
 * Indeed, the passcode does not repeat any digits and can be solved by hand.
 * Brute force of all permutations is implemented below.
 * A rigorous solution that is scalable to a larger passcode and alphabet will be slower.
 */
public class Problem079 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new FileReader("src/input/p079_keylog.txt"));
        List<List<Integer>> a = new ArrayList<>();
        while (br.ready()) {
            int x = Integer.parseInt(br.readLine());
            List<Integer> b = new ArrayList<>();
            while (x > 0) {
                b.add(0, x % 10);
                x /= 10;
            }
            a.add(b);
        }

        int[] p = {0, 1, 2, 3, 6, 7, 8, 9};
        for (int i = 0; i < 40320; i++) {
            boolean flag = true;
            for (List<Integer> b : a) {
                int j = 0, k = 0;
                while (j < p.length && k < b.size()) {
                    if (p[j] == b.get(k)) {
                        k++;
                    }
                    j++;
                }
                if (k < b.size()) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                for (int e : p) {
                    System.out.print(e);
                }
                return;
            }
            generateNextPermutation(p);
        }
    }
}
