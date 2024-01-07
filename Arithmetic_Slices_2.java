// Topic:- Dynamic Programming

  
// Approach
// 1. Mapping Elements to Indices:

// Create a hashmap nums2mp to store each unique number in nums as a key, with its associated indices as values. This allows for efficient lookup of potential arithmetic sequence predecessors.
// 2. Dynamic Programming Table:

// Create a 2D DP table dp where dp[i][j] represents the number of arithmetic slices ending at index i with the second-to-last element at index j.
// 3. Nested Iteration and Lookup:

// Iterate through all pairs of indices i and j (where i > j):
// Calculate the potential predecessor prev using the formula 2 * nums[j] - nums[i].
// Check if prev exists in the hashmap nums2mp.
// If it does, iterate through its associated indices k (where k < j):
// Update dp[i][j] by adding dp[j][k] + 1, effectively counting the arithmetic slices formed by extending existing slices.
// 4. Counting Slices:

// Add dp[i][j] to the result res in each iteration, as it represents the newly formed arithmetic slices ending at index i with the second-to-last element at index j.
// 5. Final Count:

// Return res, which holds the total number of arithmetic slices in the input array.
// Time Complexity:

// O(N^3)
// The nested loops iterate through all pairs of indices, resulting in N^2 iterations.
// The lookup and inner loop within each iteration contribute an additional N factor.
// Space Complexity:

// O(N^2)
// The DP table dp uses O(N^2) space.
// The hashmap nums2mp uses O(N) space in the typical case.

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        Map<Integer, List<Integer>> nums2mp = new HashMap<>();
        int len = nums.length;
        int[][] dp = new int[len][len];
        int res = 0;
        for (int i = 0; i < len; i++) {
            nums2mp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                long prev = 2L * nums[j] - nums[i];
                if (prev > Integer.MAX_VALUE || prev < Integer.MIN_VALUE) {
                    continue;
                }
                List<Integer> indices = nums2mp.getOrDefault((int) prev, null);
                if (indices != null) {
                    for (int k : indices) {
                        if (k >= j) break;
                        dp[i][j] += dp[j][k] + 1;
                    }
                }
                res += dp[i][j];
            }
        }
        return res;
    }
}
