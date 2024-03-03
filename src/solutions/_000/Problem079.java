package solutions._000;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static utils.Miscellaneous.generateNextPermutation;

/**
 * Implementation below assumes passcode contains no repeated digits.
 */
public class Problem079 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new FileReader("src/resource/p079_keylog.txt"));
        List<List<Integer>> a = new ArrayList<>();
        while (br.ready()) {
            int x = parseInt(br.readLine());
            a.add(List.of(x / 100, (x / 10) % 10, x % 10));
        }

        int[] p = {0, 1, 2, 3, 6, 7, 8, 9};
        while (true) {
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
