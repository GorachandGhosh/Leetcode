/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        
        while (curr != null) {
            if (p.val < curr.val && q.val < curr.val) {
                // Both are in the left subtree
                curr = curr.left;
            } else if (p.val > curr.val && q.val > curr.val) {
                // Both are in the right subtree
                curr = curr.right;
            } else {
                // We found the split point or one of the nodes
                return curr;
            }
        }
        return null;
    }
}
