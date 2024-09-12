package org.algocoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MaxHeight {
    private static final int[] coins = new int[]{2, 3, 5};
    private static int cnt;
    private static int maxHeight;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {

            int amount = Integer.valueOf(reader.readLine());
            cnt = 0;
            maxHeight = 0;
            int totalCombinations = coinChange(amount, 0, 0);
            System.out.println(String.format("Total Combinations: %,d\n", totalCombinations));
            System.out.println(String.format("Recursion Counter: %,d\n", cnt));
            System.out.println("Max Height: " + maxHeight);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int coinChange(int amount, int coinIndex, int height) {
        cnt++;

        if (amount == 0) {
            if (height > maxHeight) {
                maxHeight = height;
            }
            return 1;
        }

        if (amount < 0 || coinIndex >= coins.length) {
            if (height > maxHeight) {
                maxHeight = height;
            }
            return 0;
        }

        return coinChange(amount - coins[coinIndex], coinIndex, height + 1) + coinChange(amount, coinIndex + 1, height + 1);
    }
}


