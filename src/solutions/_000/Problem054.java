package solutions._000;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/*
 * Implementation: compare each set of poker hands.
 */
public class Problem054 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new FileReader("src/resource/p054_poker.txt"));
        int cnt = 0;
        for (int i = 0; i < 1000; i++) {
            String[] split = br.readLine().split("\\s");
            Card[] cards = new Card[10];
            for (int j = 0; j < 10; j++) {
                cards[j] = new Card(split[j]);
            }
            if (new Hand(cards[0], cards[1], cards[2], cards[3], cards[4]).compareTo(new Hand(cards[5], cards[6], cards[7], cards[8], cards[9])) > 0) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static class Card implements Comparable<Card> {
        int r, s;

        private Card(String c) {
            String a = "23456789TJQKA", b = "CDHS";
            r = a.indexOf(c.charAt(0));
            s = b.indexOf(c.charAt(1));
        }

        public int compareTo(Card o) {
            return Integer.compare(r, o.r);
        }
    }

    private static class Hand implements Comparable<Hand> {
        Card[] h; // array of sorted cards by rank
        int[] ord; // array for comparing hand. First value is rank, all other values are cards to be compared from highest to lowest.

        private Hand(Card a, Card b, Card c, Card d, Card e) {
            h = new Card[] {a, b, c, d, e};
            Arrays.sort(h);
            ord = new int[6];
            // flush
            if (h[0].s == h[1].s && h[0].s == h[2].s && h[0].s == h[3].s && h[0].s == h[4].s) {
                // royal flush
                if (h[0].r == 8 && h[1].r == 9 && h[2].r == 10 && h[3].r == 11 && h[4].r == 12) {
                    ord[0] = 9;
                }
                // straight flush
                else if (h[1].r == h[0].r + 1 && h[2].r == h[0].r + 2 && h[3].r == h[0].r + 3 && h[4].r == h[0].r + 4) {
                    ord[0] = 8;
                    ord[1] = h[4].r;
                }
                // flush
                else {
                    ord[0] = 5;
                    ord[1] = h[4].r;
                    ord[2] = h[3].r;
                    ord[3] = h[2].r;
                    ord[4] = h[1].r;
                    ord[5] = h[0].r;
                }
            }
            // four of a kind
            else if (h[0].r == h[3].r) {
                ord[0] = 7;
                ord[1] = h[2].r;
                ord[2] = h[4].r;
            }
            else if (h[1].r == h[4].r) {
                ord[0] = 7;
                ord[1] = h[2].r;
                ord[2] = h[0].r;
            }
            // full house
            else if (h[0].r == h[2].r && h[3].r == h[4].r) {
                ord[0] = 6;
                ord[1] = h[2].r;
                ord[2] = h[4].r;
            }
            else if (h[2].r == h[4].r && h[0].r == h[1].r) {
                ord[0] = 6;
                ord[1] = h[2].r;
                ord[2] = h[0].r;
            }
            // straight
            else if (h[1].r == h[0].r + 1 && h[2].r == h[0].r + 2 && h[3].r == h[0].r + 3 && h[4].r == h[0].r + 4) {
                ord[0] = 4;
                ord[1] = h[4].r;
            }
            // three of a kind
            else if (h[0].r == h[2].r) {
                ord[0] = 3;
                ord[1] = h[2].r;
                ord[2] = h[4].r;
                ord[3] = h[3].r;
            }
            else if (h[1].r == h[3].r) {
                ord[0] = 3;
                ord[1] = h[2].r;
                ord[2] = h[4].r;
                ord[3] = h[0].r;
            }
            else if (h[2].r == h[4].r) {
                ord[0] = 3;
                ord[1] = h[2].r;
                ord[2] = h[1].r;
                ord[3] = h[0].r;
            }
            // two pairs
            else if (h[0].r == h[1].r && h[2].r == h[3].r) {
                ord[0] = 2;
                ord[1] = h[3].r;
                ord[2] = h[1].r;
                ord[3] = h[4].r;
            }
            else if (h[0].r == h[1].r && h[3].r == h[4].r) {
                ord[0] = 2;
                ord[1] = h[3].r;
                ord[2] = h[1].r;
                ord[3] = h[2].r;
            }
            else if (h[1].r == h[2].r && h[3].r == h[4].r) {
                ord[0] = 2;
                ord[1] = h[3].r;
                ord[2] = h[1].r;
                ord[3] = h[0].r;
            }
            // one pair
            else if (h[0].r == h[1].r) {
                ord[0] = 1;
                ord[1] = h[0].r;
                ord[2] = h[4].r;
                ord[3] = h[3].r;
                ord[4] = h[2].r;
            }
            else if (h[1].r == h[2].r) {
                ord[0] = 1;
                ord[1] = h[1].r;
                ord[2] = h[4].r;
                ord[3] = h[3].r;
                ord[4] = h[0].r;
            }
            else if (h[2].r == h[3].r) {
                ord[0] = 1;
                ord[1] = h[2].r;
                ord[2] = h[4].r;
                ord[3] = h[1].r;
                ord[4] = h[0].r;
            }
            else if (h[3].r == h[4].r) {
                ord[0] = 1;
                ord[1] = h[3].r;
                ord[2] = h[2].r;
                ord[3] = h[1].r;
                ord[4] = h[0].r;
            }
            // high card
            else {
                ord[0] = 0;
                ord[1] = h[4].r;
                ord[2] = h[3].r;
                ord[3] = h[2].r;
                ord[4] = h[1].r;
                ord[5] = h[0].r;
            }
        }

        public int compareTo(Hand o) {
            for (int i = 0; i < 6; i++) {
                if (ord[i] < o.ord[i]) {
                    return -1;
                }
                if (ord[i] > o.ord[i]) {
                    return 1;
                }
            }
            return 0;
        }
    }
}
