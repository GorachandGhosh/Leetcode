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
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDiameter;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;

        // Recursively find the height of left and right subtrees
        int left = height(node.left);
        int right = height(node.right);

        // Update the global maximum diameter
        // (number of edges = sum of heights of left and right children)
        maxDiameter = Math.max(maxDiameter, left + right);

        // Return the height of the current node to its parent
        return 1 + Math.max(left, right);
    }
}