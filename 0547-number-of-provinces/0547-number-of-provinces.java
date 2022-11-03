class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j] == 1 && i != j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        
        int ans = 0;
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                ans++;
                dfs(i, visited, adj);
            }
        }
        return ans;
    }
    
    void dfs(int ver, boolean[] visited, List<List<Integer>> adj){
        visited[ver] = true;
        
        for(int v: adj.get(ver)){
            if(!visited[v]){
                dfs(v, visited, adj);
            }
        }
    }
}