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
    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        inorder(root, list);
        TreeNode first = null;
        TreeNode middle = null;
        TreeNode last = null;
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);
        for(TreeNode node: list){
            if(prev.val > node.val){
                if(first == null && middle == null){
                    first = prev;
                    middle = node;
                }
                else{
                    last = node;
                }
            }
            prev = node;
        }
        
        if(last == null){
            int temp = middle.val;
            middle.val = first.val;
            first.val = temp;
        }
        else{
            int temp = last.val;
            last.val = first.val;
            first.val = temp;
        }
    }
    
    void inorder(TreeNode root, ArrayList<TreeNode> list){
        if(root == null){
            return;
        }
        
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
}