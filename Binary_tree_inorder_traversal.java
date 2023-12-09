// Intuition
// The inorder traversal of a binary tree visits the left subtree, the root, and then the right subtree. The goal is to accumulate the node values in the correct order.

// Approach
// We use a recursive helper function to perform the inorder traversal.
// In the helper function, we traverse the left subtree, add the root value to the result, and then traverse the right subtree.
// The base case ensures that the traversal stops when we reach a null node.
// Complexity
// Time Complexity: O(n), where n is the number of nodes in the binary tree. We visit each node once.
// Space Complexity: O(h), where h is the height of the binary tree. The space is used for the recursive call stack, and in the worst case (skewed tree), it's O(n). In the average case (balanced tree), it's O(log n).
// Code
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            helper(root.left, res);
            res.add(root.val);
            helper(root.right, res);
        }
    }
}
