// Intuition
// To find the special positions in the binary matrix, we need to iterate through each row and column and check if the current position (i, j) is special. A position is considered special if the element at that position is 1, and all other elements in its row and column are 0.

// Approach
// Iterate through each row of the matrix.
// For each row, check if there is exactly one element with the value 1. If found, remember its column index.
// After scanning the row, check the corresponding column for the remembered index. If the element is 1 and there are no other 1s in that column, it's a special position.
// Repeat this process for all rows.
// Count and return the number of special positions.
  
// Complexity
// Time Complexity: O(m * n), where m is the number of rows and n is the number of columns in the matrix.
// Space Complexity: O(1) as we use constant space.
  
// Code
class Solution {
    public int numSpecial(int[][] mat) {
        
        int specials = 0;

        for (int i = 0; i < mat.length; i++) {
            int index = checkRow(mat, i);
            if (index >= 0 && checkColumn(mat, i, index))
                specials++;
        }

        return specials;
    }

    private int checkRow(int[][] mat, int i) {
        int index = -1;
        for (int j = 0; j < mat[0].length; j++) {
            if (mat[i][j] == 1) {
                if (index >= 0)
                    return -1;
                else
                    index = j;
            }
        }
        return index;
    }

    private boolean checkColumn(int[][] mat, int i, int index) {
        for (int j = 0; j < mat.length; j++) {
            if (mat[j][index] == 1 && j != i)
                return false;
        }
        return true;
    }
}
