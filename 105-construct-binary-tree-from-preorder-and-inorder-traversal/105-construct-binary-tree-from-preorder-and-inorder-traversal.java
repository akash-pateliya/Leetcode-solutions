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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }
    
    TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd, HashMap<Integer, Integer> map){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[preStart]);
        
        int rootIndex = map.get(preorder[preStart]);
        
        node.left = build(preorder, inorder, preStart + 1, preStart + (rootIndex - inStart), inStart, rootIndex - 1, map);
        
        node.right = build(preorder, inorder, preStart + (rootIndex - inStart) + 1, preEnd, rootIndex + 1, inEnd, map);
        
        return node;
    }
}