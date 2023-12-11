// The description say "more than 25%", that means length of target number should be at least quarter of length of input array.
// If the number two steps ahead is the same as the current number, it can be considered as 25%.

// Be careful, we need to include the current number because 2 / 9 = 0.22222...not more than 25%. If we include the current number, 3 / 9 = 0.33333...

// One more point is that we don't have to iterate all numbers in input array, because we compare the current number and the number in current index + quarter, so number of max iteration should be total length of input array - quarter.
// Time complexity: O(n−quarter)
// Space complexity: O(1)

class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int quarter = n / 4;

        for (int i = 0; i < n - quarter; i++) {
            if (arr[i] == arr[i + quarter]) {
                return arr[i];
            }
        }

        return -1;
    }
}
