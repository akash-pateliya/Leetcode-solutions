class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int[] color =  new int[graph.length];
        Arrays.fill(color, -1);
        for(int i=0; i<graph.length; i++){
            if(color[i] == -1){
                if(!checkBipartite(i, color, graph)){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    boolean checkBipartite(int vertex, int[] color, int[][] graph){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(vertex);
        color[vertex] = 1;
        
        while(!queue.isEmpty()){
            int top = queue.remove();
            
            for(int ver: graph[top]){
                if(color[ver] == -1){
                    color[ver] = 1 - color[top];
                    queue.add(ver);
                }
                else if(color[ver] == color[top]){
                    return false;
                }
            }
        }
        
        return true;
    }
}