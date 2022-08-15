class Solution {
    public int findCircleNum(int[][] isConnected) {
        //Initially convert the adjacency matrix to an adjacency List
        List<List<Integer>> adj = new ArrayList<>();
        
        //Calculate the length
        int n = isConnected.length;
    
        //add an empty arraylist in front of every index
        for(int i=0;i<n;i++){
        adj.add(new ArrayList());
        }
        
        //Mark every edge in the adjacency list.
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i == j)
                    continue;
                if(isConnected[i][j] == 1)
                    adj.get(i).add(j);
            }
        }
        
        //The approach is to call the dfs a node, that dfs call will mark all its connections as visited.
        //The moment we need to enter the if block means we have found a new province.
        int ans = 0;
        boolean vis[] = new boolean[n];
        
        for(int i=0;i<n;i++)
        {
            if(vis[i] == false) 
            {
                ans++;
                dfs(adj,i,vis);
            }
        }
        return ans;
    }
    
    void dfs(List<List<Integer>> adj,int src,boolean[] vis)
    {
        vis[src] = true;
        
        for(int nbr : adj.get(src))
        {
            if(vis[nbr] == false)
                dfs(adj,nbr,vis);
        }
    }
}