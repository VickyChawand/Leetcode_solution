// Intuition
// The transpose of a matrix can be obtained by swapping its rows and columns. We iterate through each element of the original matrix and fill the corresponding position in the transposed matrix.

// Approach
// Determine the number of rows (row) and columns (col) in the original matrix.
// Create a new matrix arr with dimensions col x row.
// Iterate through each element of the original matrix, assigning it to the corresponding position in the transposed matrix.
// Return the transposed matrix.
// Complexity
// Time Complexity: O(m * n) where m and n are the number of rows and columns in the matrix.
// Space Complexity: O(m * n) for the transposed matrix.
Code
class Solution {
    public int[][] transpose(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int arr[][]=new int[col][row];
        for(int i=0;i<col;i++)
        {
            for(int j=0;j<row;j++)
            {
            arr[i][j]=matrix[j][i];
            }
        }
        return arr;
    }
}
