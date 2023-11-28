// Intuition
// To divide the corridor into non-overlapping sections with exactly two seats and any number of plants in between, we need to identify the positions where dividers can be installed. The problem constrains the installation of dividers such that each position between indices i-1 and i (1 <= i <= n - 1) can have at most one divider.

// Approach
// Initialize variables to keep track of chairs, result, and iterate through the corridor.
// When a seat ('S') is encountered, count it, skip any plants ('P') until the next seat is found, and count that seat as well.
// After identifying adjacent pairs of seats, count the divisions between them and consider each plant as an additional division.
// If there are extra divisions (more than one) and more characters in the corridor, update the result accordingly.
// Repeat the process until the end of the corridor is reached.
// Check if there are chairs and an even number of chairs, then return the final result; otherwise, return 0.
// Complexity
// The time complexity is O(n), where n is the length of the corridor, as we iterate through the corridor once.
// The space complexity is O(1), as we use a constant amount of space for variables.


// Code
class Solution {
    public int numberOfWays(String corridor) {

        char[] array = corridor.toCharArray();
        int chairs = 0;
        long result = 1;

        for (int i = 0; i < array.length; i++) {

            
            if (array[i] == 'S') {
                chairs++;

                
                while (++i < array.length && array[i] != 'S');
                if (i < array.length && array[i] == 'S') {
                    chairs++;
                }


                
                int divisions = 1;
                while (++i < array.length && array[i] != 'S') {
                    divisions++;
                }

                           
                if (divisions > 1 && i < array.length) {
                    result = (result * divisions) % 1000000007;
                }
                i--;
            }
        }

        return (chairs != 0 && chairs % 2 == 0) ? (int) result : 0;
    }
}
