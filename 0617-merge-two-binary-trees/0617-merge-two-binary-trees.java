/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // Base Cases: If one node is null, return the other
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        
        // If both exist, sum values into the first tree's node
        root1.val += root2.val;
        
        // Recursively merge left and right subtrees
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        
        // Return the modified root1 as the new merged tree
        return root1;
    }
}