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
    private int runningSum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            // 1. Visit the right subtree (larger values)
            bstToGst(root.right);
            
            // 2. Update the running sum and current node value
            runningSum += root.val;
            root.val = runningSum;
            
            // 3. Visit the left subtree (smaller values)
            bstToGst(root.left);
        }
        return root;
    }
}
