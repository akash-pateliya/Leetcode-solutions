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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.add(root);
            queue.add(null);
        }
        else{
            return ans;
        }

        
        while(!queue.isEmpty()){
            TreeNode temp = queue.remove();
            
            if(temp == null){
                ans.add(list);
                if(!queue.isEmpty()){
                    list = new ArrayList<>();
                    queue.add(null);
                }
            }
            else{
                list.add(temp.val);
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
        }
        
        return ans;
    }
    
}