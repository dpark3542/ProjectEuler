package solutions.java;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by dpark3542 on 5/11/2017.
 */
public class Problem024 {
    /*
     * Brute force: generate all permutations and find the millionth permutation.
     * Algorithms such as Heap's algorithm generate all permutations but not in lexicographic order. Sort the permutations after generation.
     * A classical algorithm first discovered by Narayana Pandita generates all permutations in lexicographic order.
     *
     * Alternative solution: In a list of n elements, notice that the ith element changes after (n-i)! permutations.
     * Using this fact, determine each digit by calculating n mod (n-i)! and choosing from the unused digits.
     *
     */
    public static void main(String[] args) {
        int n = 1000000 - 1;
        List<Integer> d = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            d.add(i);
        }
        int[] f = new int[10];
        f[0] = 1;
        for (int i = 1; i <= 9; i++) {
            f[i] = f[i - 1] * i;
        }
        long ans = 0;
        for (int i = 9; i >= 0; i--) {
            ans = 10 * ans + d.get(n / f[i]);
            d.remove(n / f[i]);
            n %= f[i];
        }
        System.out.println(ans);
    }
}
