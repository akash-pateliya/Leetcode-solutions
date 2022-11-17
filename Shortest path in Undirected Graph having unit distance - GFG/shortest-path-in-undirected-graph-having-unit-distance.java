//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    class Pair{
        int ver;
        int dist;
        
        Pair(int a, int b){
            this.ver = a;
            this.dist = b;
        }
    }
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        //create adj list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i = 0;i<m;i++) {
            adj.get(edges[i][0]).add(edges[i][1]); 
            adj.get(edges[i][1]).add(edges[i][0]); 
        }
        
        int[] res = new int[n];
        Arrays.fill(res, -1);
        
        Queue<Pair> queue = new LinkedList<Pair>();
        res[src] = 0;
        queue.add(new Pair(src, 0));
        
        while(!queue.isEmpty()){
            Pair top = queue.remove();
            int ver = top.ver;
            int dist = top.dist;
            
            for(int v: adj.get(ver)){
                if(res[v] == -1 || dist + 1 < res[v]){
                    res[v] = dist+1;
                    queue.add(new Pair(v, dist+1));
                }
            }
        }
        
        return res;
    }
}