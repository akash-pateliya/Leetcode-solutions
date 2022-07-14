class Solution {
    class Tuples{
        int data;
        int row;
        int col;
        
        Tuples(int d, int r, int c){
            this.data = d;
            this.row = r;
            this.col = c;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Tuples> minHeap = new PriorityQueue<Tuples>(new Comparator<Tuples>(){
            public int compare(Tuples a, Tuples b){
                return a.data - b.data;
            }
        });
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.size(); i++){
            min = Math.min(min, nums.get(i).get(0));
            max = Math.max(max, nums.get(i).get(0));
            minHeap.add(new Tuples(nums.get(i).get(0), i, 0));
        }
        
        int start = min, end = max;
        while(!minHeap.isEmpty()){
            Tuples top = minHeap.remove();
            min = top.data;
            if((max - min) < (end - start)){
                start = min;
                end = max;
            }
            if(top.col + 1 < nums.get(top.row).size()){
                int ele = nums.get(top.row).get(top.col + 1);
                max = Math.max(max, ele);
                minHeap.add(new Tuples(ele, top.row, top.col+1));
            }
            else{
                break;
            }
        }
        
        return new int[]{start, end};
    }
}