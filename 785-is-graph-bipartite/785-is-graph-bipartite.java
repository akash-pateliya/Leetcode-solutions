class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int[] color =  new int[graph.length];
        Arrays.fill(color, -1);
        for(int i=0; i<graph.length; i++){
            if(color[i] == -1){
                if(!checkBipartite(i, color, graph, 0)){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    boolean checkBipartite(int vertex, int[] color, int[][] graph, int prevColour){
        color[vertex] = 1 - prevColour;
        
            for(int ver: graph[vertex]){
                if(color[ver] == -1){
                    if(!checkBipartite(ver, color, graph, 1 - prevColour)){
                        return false;
                    }
                }
                else if(color[ver] == (1 - prevColour)){
                    return false;
                }
            }
        
        return true;
    }
}