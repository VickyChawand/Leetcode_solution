// Intuition
// The problem requires constructing a string representation of a binary tree using the preorder traversal approach. The key is to handle the omission of unnecessary empty parenthesis pairs while maintaining a one-to-one mapping relationship between the string and the original binary tree.

// Approach
// Initialize a StringBuilder (res) to construct the final string representation.
// Implement a recursive depth-first search (DFS) function (dfs) to traverse the binary tree.
// Append the current node's value to the result string.
// Check if the current node has left and right children:
// If it has only a left child, append '(' and recursively call dfs on the left child.
// If it has both left and right children, append '(' and recursively call dfs on both the left and right children.
// After handling the left children, if the current node has a right child, append '(' and recursively call dfs on the right child.
// Close the parenthesis after handling the left and right children.
// The final result is obtained as a string from the StringBuilder.
// Complexity
// The time complexity is O(N), where N is the number of nodes in the binary tree. We visit each node exactly once during the DFS traversal.

// The space complexity is O(H), where H is the height of the binary tree. In the worst case, the recursion stack can go as deep as the height of the tree.

// Code

class Solution {
    public String tree2str(TreeNode t) {
        StringBuilder res = new StringBuilder();
        dfs(t, res);
        return res.toString();
    }

    public static void dfs(TreeNode t, StringBuilder res) {
        if (t == null)
            return;
        res.append(String.valueOf(t.val));
        if (t.left == null && t.right == null)
            return;
        res.append('(');
        dfs(t.left, res);
        res.append(')');
        if (t.right != null) {
            res.append('(');
            dfs(t.right, res);
            res.append(')');
        }
    }
}
