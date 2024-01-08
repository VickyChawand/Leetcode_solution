// Approaches

// Function Purpose: The function rangeSumBST calculates the sum of node values within the given range [L, R] in a Binary Search Tree.

// Base Case Handling: If the current node (root) is nullptr (i.e., the tree/subtree is empty), the function returns 0 as there are no values to sum within an empty tree.

// Node Value Comparison: It checks whether the value of the current node (root->val) is within the given range [L, R].

// Recursive Sum Calculation:

// If the value falls within the range, it includes the current node's value in the sum and recursively calls the function for its left and right subtrees.
// If the value is less than L, it means the current node's value and its left subtree's values are smaller than L, so it focuses only on the right subtree.
// If the value is greater than R, it means the current node's value and its right subtree's values are greater than R, so it focuses only on the left subtree.
// Returning Sum: The function recursively computes the sum of values satisfying the given range conditions and returns the total sum of node values within the range [L, R].

// Complexity
// Time complexity:
// O(n)

// Space complexity:
// O(h)
// (where H is the height of the tree)

  
class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        
        if (root.val >= L && root.val <= R) {
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        } else if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        } else {
            return rangeSumBST(root.left, L, R);
        }
    }
}
