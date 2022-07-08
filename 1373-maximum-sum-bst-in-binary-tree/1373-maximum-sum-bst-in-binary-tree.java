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
    
    class Data{
        int sum, min, max;
        boolean isBst;
        public Data(){
            sum = 0;
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            isBst = true;
        }
    }
    
    int max = 0;
    public int maxSumBST(TreeNode root) {
        helper(root);
        return max;
    }
    
    public Data helper(TreeNode root){
        if(root == null) return new Data();
        
        Data left = helper(root.left);
        Data right = helper(root.right);
        
        Data root_data = new Data();
        root_data.min = Math.min(left.min, root.val);
        root_data.max = Math.max(right.max, root.val);
        
        root_data.isBst = (left.isBst && right.isBst && left.max < root.val && root.val < right.min);
        if(root_data.isBst) root_data.sum = root.val + left.sum + right.sum;
        
        max = Math.max(max, root_data.sum);
        return root_data;
    }
}