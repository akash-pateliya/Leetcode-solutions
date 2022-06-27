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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        boolean isLeftToRight = true;
        Queue<TreeNode> queue = new LinkedList<>();
        
        if(root != null){
            queue.add(root);
        }
        
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            
            for(int i=0; i<size; i++){
                TreeNode temp = queue.remove();
                if(isLeftToRight){
                    list.add(temp.val);
                }
                else{
                    list.add(0, temp.val);
                }
                
                if(temp.left != null){
                    queue.add(temp.left);
                }
                
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
            isLeftToRight = !isLeftToRight;
            ans.add(new ArrayList<Integer>(list));
        }
        
        return ans;
    }
}