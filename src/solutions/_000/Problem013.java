package solutions._000;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

import static java.math.BigInteger.ZERO;

/*
 * Brute force: sum all numbers
 */
public class Problem013 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new FileReader("src/resource/p013_numbers.txt"));
        BigInteger sum = ZERO;
        while (br.ready()) {
            sum = sum.add(new BigInteger(br.readLine()));
        }

        System.out.println(sum.toString().substring(0, 10));
    }
}
