// Problem Explaination:
// The problem is asking us to write a function that takes a binary representation of a positive integer and counts the number of '1' bits (also known as the Hamming weight). The input to the function will be the binary form of a positive integer. The goal is to count how many '1' bits are present in that binary representation.

// Some additional notes to keep in mind:
// In some programming languages, such as Java, there is no explicit unsigned integer type. Even if the input is given as a signed integer, you can still treat its internal binary representation as if it were unsigned.
// In Java, signed integers are represented using 2's complement notation. This means that negative numbers are represented in a specific way in binary. However, for this problem, you should focus on counting the '1' bits, regardless of whether the input is positive or negative.
// 🔍 Methods To Solve This Problem:
// I'll be covering three different methods to solve this problem:

// Brian Kernighan's Algorithm
// Bit Manipulation
// String Conversion
// 1. Brian Kernighan's Algorithm:
// Initialize a count variable to 0.
// Iterate through each bit of the number using the following steps:
// If the current bit is 1, increment the count.
// Set the current bit to 0 using the expression n = n & (n - 1).
// The count variable now holds the number of 1 bits.
// Complexity
// ⏱️ Time Complexity: O(k), where k is the number of set bits in the binary representation of the number.

// 🚀 Space Complexity: O(1)

  public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}

// 2. Bit Manipulation:
// Initialize a count variable to 0.
// Iterate through each bit of the number using a loop.
// If the current bit is 1, increment the count.
// The count variable now holds the number of 1 bits.
// Complexity
// ⏱️ Time Complexity: O(log n), where n is the value of the input number.

// 🚀 Space Complexity: O(1)

// Code
  public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }
}

// 3. String Conversion:
// Convert the integer to its binary string representation.
// Count the number of '1' characters in the binary string
// Complexity
// ⏱️ Time Complexity: O(log n), where n is the value of the input number.

// 🚀 Space Complexity:O(log n)

// Code

  public class Solution {
    public int hammingWeight(int n) {
        String binaryString = Integer.toBinaryString(n);
        int count = 0;
        for (char c : binaryString.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }
}
