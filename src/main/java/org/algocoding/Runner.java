package org.algocoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Runner {
    private static final int[] coins = new int[]{2, 3, 5};
    private static int[][] memoization = new int[1000][3];

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
            Arrays.stream(memoization).forEach(amounts -> Arrays.fill(amounts, -1));
            int amount = Integer.valueOf(reader.readLine());
            int totalCombinations = coinChange(amount, 0);
            System.out.println(String.format("Total Combinations: %,d\n", totalCombinations));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int coinChange(int amount, int coinIndex) {
        if (amount == 0) {
            return 1;
        }

        if (amount < 0 || coinIndex >= coins.length) {
            return 0;
        }

        if (memoization[amount][coinIndex] > -1) {
            return memoization[amount][coinIndex];
        }

        return memoization[amount][coinIndex] = coinChange(amount - coins[coinIndex], coinIndex) + coinChange(amount, coinIndex + 1);
    }
}


