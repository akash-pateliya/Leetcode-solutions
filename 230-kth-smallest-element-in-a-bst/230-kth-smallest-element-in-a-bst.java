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
    public int kthSmallest(TreeNode root, int k) {
        int[] count = new int[1];
        count[0] = 0;
        TreeNode node = solve(root, count, k);
        return node.val;
    }
    
    TreeNode solve(TreeNode root, int[] count, int k){
        if(root == null){
            return null;
        }
        
        TreeNode left = solve(root.left, count, k);
        if(left != null){
            return left;
        }
        count[0] = count[0] + 1;
        if(count[0] == k){
            return root;
        }
        return solve(root.right, count, k);
    }
}