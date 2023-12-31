//Approach

//The approach of this code is based on dynamic programming to compute the number of distinct phone numbers of length n that a knight can dial, starting from any digit. The knight moves according to the valid knight moves on a phone pad, and the goal is to find the total number of valid phone numbers of length n.

//Initialization:

//Initialize a 2D array dp of size n x 10, where n is the length of the phone number and 10 represents the possible digits.
//Set the values in the first row of dp to 1 because there is only one way to reach each digit from the starting position (the knight is already there).

//DynamicProgrammingIteration:

//Use a nested loop structure to iterate over the steps (i) and digits (j).
//For each step and digit, iterate over the possible next moves from the current digit according to the valid knight moves.
//Update the count in dp[i][j] by adding the counts from the previous step (dp[i-1][next]), considering all possible moves.
//Take the result modulo 1_000_000_007 to handle large numbers.

//ResultCalculation:

//After completing the dynamic programming steps, calculate the final result by summing up the counts for each digit in the last row of dp.
//Return the result modulo 1_000_000_007 as the answer may be very large.

//Complexity
//Time complexity: O(n)
//Space complexity: O(n)

//Code

class Solution {
    public int knightDialer(int n) {
        final int MOD = 1_000_000_007;
        int[][] moves = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};
        int[][] dp = new int[n][10];
        Arrays.fill(dp[0], 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int next : moves[j]) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][next]) % MOD;
                }
            }
        }

        int result = 0;
        for (int count : dp[n - 1]) {
            result = (result + count) % MOD;
        }

        return result;
    }
}
