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
import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedNodes = new ArrayList<>();
        inorderTraversal(root, sortedNodes);
        
        // Build the balanced tree from the sorted list
        return buildBalancedTree(sortedNodes, 0, sortedNodes.size() - 1);
    }
    
    // Step 1: Extract node values in sorted order
    private void inorderTraversal(TreeNode node, List<Integer> sortedNodes) {
        if (node == null) return;
        inorderTraversal(node.left, sortedNodes);
        sortedNodes.add(node.val);
        inorderTraversal(node.right, sortedNodes);
    }
    
    // Step 2: Recursively build the tree picking the middle element
    private TreeNode buildBalancedTree(List<Integer> sortedNodes, int start, int end) {
        if (start > end) return null;
        
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(sortedNodes.get(mid));
        
        root.left = buildBalancedTree(sortedNodes, start, mid - 1);
        root.right = buildBalancedTree(sortedNodes, mid + 1, end);
        
        return root;
    }
}
