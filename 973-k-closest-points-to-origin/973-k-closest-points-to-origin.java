class Solution {
    class Tuples{
        int distance;
        int row;
        int col;
        
        Tuples(int dist, int a, int b){
            this.distance = dist;
            this.row = a;
            this.col = b;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Tuples> maxHeap = new PriorityQueue<Tuples>(new Comparator<Tuples>(){
            public int compare(Tuples a, Tuples b){
                return b.distance - a.distance;
            }
        });
        
        for(int[] arr: points){
            int x = arr[0];
            int y = arr[1];
            
            int distance = (x * x) + (y * y);
            maxHeap.add(new Tuples(distance, x, y));
            if(maxHeap.size() > k){
                maxHeap.remove();
            }
        }
        
        int[][] ans = new int[k][2];
        int i = 0;
        while(!maxHeap.isEmpty()){
            Tuples temp = maxHeap.remove();
            ans[i][0] = temp.row;
            ans[i][1] = temp.col;
            i++;
        }
        return ans;
    }
}