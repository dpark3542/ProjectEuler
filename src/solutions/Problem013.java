package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

/**
 * Created by dpark on 5/7/2017.
 */
public class Problem013 {
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new FileReader("src/input/p013_numbers"));
        BigInteger sum = BigInteger.ZERO;
        while (br.ready()) {
            sum = sum.add(new BigInteger(br.readLine()));
        }

        System.out.println(sum.toString().substring(0, 10));
    }
}
