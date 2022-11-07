//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    static class Pair{
        int curr;
        int prev;
        
        Pair(int _curr, int _prev){
            this.curr = _curr;
            this.prev = _prev;
        }
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited =  new boolean[V];
        
        for(int i=0; i<V; i++){
            if(!visited[i]){
                Queue<Pair> queue = new LinkedList<Pair>();
                queue.add(new Pair(i, -1));
                visited[i] = true;
                
                while(!queue.isEmpty()){
                    Pair top = queue.remove();
                    
                    for(int ver: adj.get(top.curr)){
                        if(!visited[ver]){
                            visited[ver] = true;
                            queue.add(new Pair(ver, top.curr));
                        }
                        else if(top.prev != ver){
                            return true;
                        }
                    }
                }
            }
        }
        
        return false;
    }
}