class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0; i<prerequisites.length; i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            
            adj.get(a).add(b);
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] currVisited = new boolean[numCourses];
        
        for(int i=0; i<numCourses; i++){
            if(!visited[i]){
                if(dfsCycle(i, visited, currVisited, adj)){
                   return false; 
                }
            }
        }
        
        return true;
    }
    
    boolean dfsCycle(int vertex,boolean[] visited,boolean[] currVisited, List<List<Integer>>  adj){
        visited[vertex] = true;
        currVisited[vertex] = true;
        
        for(int ver : adj.get(vertex)){
            if(!visited[ver]){
                if(dfsCycle(ver,visited, currVisited, adj)){
                    return true;
                }
            }
            else if(visited[ver] && currVisited[ver]){
                return true;
            }
        }
        
        currVisited[vertex] = false;
        return false;
    }
}