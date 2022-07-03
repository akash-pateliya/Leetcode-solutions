/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
	        return "";
	    }
	    //code here
        StringBuilder sb = new StringBuilder();
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();
	    queue.add(root);
	    while(!queue.isEmpty()){
	        TreeNode top = queue.remove();
	        if(top ==  null){
	            sb.append("N ");
	            continue;
	        }
	        sb.append(top.val + " ");
	        queue.add(top.left);
	        queue.add(top.right);
	    }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == ""){
            return null;
        }
        //code here
        String[] str = data.split(" ");
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        queue.add(root);
                        

        for(int i=1; i<str.length; i++){
            TreeNode top = queue.remove();
            if(!str[i].equals("N")){
                top.left = new TreeNode(Integer.parseInt(str[i]));
                queue.add(top.left);
            }
            
            if(!str[++i].equals("N")){
                top.right = new TreeNode(Integer.parseInt(str[i]));
                queue.add(top.right);
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));