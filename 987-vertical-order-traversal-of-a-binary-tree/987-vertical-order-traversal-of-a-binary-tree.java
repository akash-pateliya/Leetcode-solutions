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
    class Tuples{
        TreeNode node;
        int vertical;
        int level;
        
        Tuples(TreeNode _node, int _vertical, int _level){
            this.node = _node;
            this.vertical = _vertical;
            this.level = _level;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuples> queue = new LinkedList<>();
        
        queue.add(new Tuples(root, 0, 0));
        while(!queue.isEmpty()){
            Tuples tuples = queue.remove();
            TreeNode temp = tuples.node;
            int vertical = tuples.vertical;
            int level = tuples.level;
            
            if(!map.containsKey(vertical)){
                map.put(vertical, new TreeMap<Integer, PriorityQueue<Integer>>());
            }
            if(!map.get(vertical).containsKey(level)){
                map.get(vertical).put(level, new PriorityQueue<Integer>());
            }
            map.get(vertical).get(level).add(temp.val);
            
            if(temp.left != null){
                queue.add(new Tuples(temp.left, vertical - 1, level + 1));
            }
            if(temp.right != null){
                queue.add(new Tuples(temp.right, vertical + 1, level + 1));
            }
        }
        
        // List<List<Integer>> ans = new ArrayList<>();
        // for(HashMap<Integer, PriorityQueue<Integer>> verticals : map.values()){
        //     ans.add(new ArrayList<Integer>());
        //     for(PriorityQueue<Integer> q: verticals.values()){
        //         while(!q.isEmpty()){
        //             ans.get(ans.size() - 1).add(q.remove());
        //         }
        //     }
        // }
        List<List<Integer>> ans = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            ans.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    ans.get(ans.size() - 1).add(nodes.poll());
                }
            }
        }
        
        return ans;
    }
}