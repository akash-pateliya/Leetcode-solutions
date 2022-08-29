class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int[] arr: prerequisites){
            adj.get(arr[0]).add(arr[1]);
        }
        
        int[] inDegree = new int[numCourses];
        
        for(List<Integer> list: adj){
            for(int num: list){
                inDegree[num] = ++inDegree[num];
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<inDegree.length; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        
        while(!queue.isEmpty()){
            int top = queue.remove();
            stack.push(top);
            
            for(int v: adj.get(top)){
                inDegree[v] = --inDegree[v];
                if(inDegree[v] == 0){
                    queue.add(v);
                }
            }
        }
        
        if(stack.size() != numCourses){
            return new int[0];
        }
        
        int[] ans = new int[numCourses];
        int idx = 0;
        while(!stack.empty()){
            ans[idx++] = stack.pop();
        }
        
        return ans;
    }
}