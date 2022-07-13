class Solution {
    class Pair{
        int freq;
        int ele;
        
        Pair(int a, int b){
            this.freq = a;
            this.ele = b;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b){
                return a.freq - b.freq;
            }
        });
        
        for(Map.Entry<Integer, Integer> m: map.entrySet()){
            minHeap.add(new Pair(m.getValue(), m.getKey()));
            if(minHeap.size() > k){
                minHeap.remove();
            }
        }
        
        int[] ans = new int[k];
        int i=0;
        while(!minHeap.isEmpty()){
            ans[i++] = minHeap.remove().ele;
        }
        return ans;
    }
}