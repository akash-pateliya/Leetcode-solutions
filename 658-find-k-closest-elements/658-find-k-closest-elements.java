class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> {
            int bDistance = Math.abs(b-x);
            int aDistance = Math.abs(a-x);
             
            return aDistance==bDistance?b-a:bDistance-aDistance;
        });
        
        for(int i=0; i<arr.length; i++){
            maxHeap.add(arr[i]);
            if(maxHeap.size() > k){
                maxHeap.remove();
            }
        }
        
        while(!maxHeap.isEmpty()){
            ans.add(maxHeap.remove());
        }
        Collections.sort(ans);
        return ans;
    }
}