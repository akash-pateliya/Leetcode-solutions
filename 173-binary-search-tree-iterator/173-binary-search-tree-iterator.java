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
class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        insertIntoStack(root);
    }
    
    public int next() {
        if(!stack.empty()){
            TreeNode top = stack.pop();
            if(top.right != null){
                insertIntoStack(top.right);
            }
            return top.val;
        }
        else{
            return -1;
        }
    }
    
    public boolean hasNext() {
        if(stack.empty()){
            return false;
        }
        else{
            return true;
        }
    }
    
    void insertIntoStack(TreeNode root){
        TreeNode cur = root;
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */