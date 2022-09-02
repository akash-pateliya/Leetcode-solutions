class Solution {
    class Pair{
        int time;
        int node;
        
        Pair(int a, int b){
            this.time = a;
            this.node = b;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i=0;i<=n; i++){
            adj.add(new ArrayList<Pair>());
        }
        
        for(int[] arr: times){
            adj.get(arr[0]).add(new Pair(arr[2], arr[1]));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.time - b.time;
            }
        });
        
        int[] time = new int[n+1];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[0] = -1;
        
        pq.add(new Pair(0, k));
        time[k] = 0;
        
        while(!pq.isEmpty()){
            Pair top = pq.remove();
            
            for(Pair obj : adj.get(top.node)){
                int currTime = obj.time + top.time;
                if(currTime < time[obj.node]){
                    time[obj.node] = currTime;
                    pq.add(new Pair(currTime, obj.node));
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<time.length; i++){
            if(time[i] == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans, time[i]);
        }
        
        return ans;
    }
}