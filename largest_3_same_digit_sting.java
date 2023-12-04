Intuition
To find the maximum good integer, we need to traverse through the given string num and identify all substrings of length 3 with only one unique digit. Among these substrings, we should choose the one with the maximum digit.

Approach
Initialize a variable result to store the maximum digit of the good integer found so far. Set it to -1 initially.
Iterate through the string num from index 0 to num.length() - 3.
Check if the substring of length 3 starting at the current index consists of only one unique digit. If yes, update the result to be the maximum of the current digit and the existing result.
After the loop, if result is still -1, it means no good integer was found, so return an empty string.
Otherwise, construct the maximum good integer using the digit stored in result and return it.
Complexity
The time complexity is O(n), where n is the length of the input string num.
The space complexity is O(1) as we are using a constant amount of space for variables.

  class Solution {
  public String largestGoodInteger(String num) {
        int result = -1;
        for (int i = 0; i + 2 < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2)) {
                result = Math.max(result, num.charAt(i) - '0');
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            builder.append((char)(48 + result));
        }
        return result == -1 ? "" : builder.toString();
    }
}
