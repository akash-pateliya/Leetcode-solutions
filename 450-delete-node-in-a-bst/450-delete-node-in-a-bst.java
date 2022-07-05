
class Solution {
    public TreeNode deleteNode(TreeNode root,int key) {
        if(root == null){
            return root;
        }
        if(root.val == key){
            return delete(root);
        }
        TreeNode cur = root;
        while(cur != null){
            if(key > cur.val){
                if(cur.right !=null && cur.right.val == key){
                    cur.right = delete(cur.right);
                    return root;
                }
                else{
                    cur = cur.right;
                }
            }
            else{
                if(cur.left != null && cur.left.val == key){
                    cur.left = delete(cur.left);
                    return root;
                }
                else{
                    cur = cur.left;
                }
            }
        }
        return root;
    }
    
    TreeNode delete(TreeNode root){
        if(root.left == null){
            return root.right;
        }
        if(root.right == null){
            return root.left;
        }
        
        TreeNode extremeLeftToRightNode = getExtremeRightNode(root.left);
        extremeLeftToRightNode.right = root.right;
        return root.left;
        
    }
    
    TreeNode getExtremeRightNode(TreeNode root){
        TreeNode cur = root;
        while(cur.right != null){
            cur = cur.right;
        }
        return cur;
    }
}