class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<Integer>();
        int[] ans = new int[nums.length - k + 1];
        
        int start = 0;
        int end = 0;
        int i = 0;
        while(end < nums.length){
            
            while(!deque.isEmpty() && deque.peekLast() < nums[end]){
                deque.removeLast();
            }
            deque.add(nums[end]);
            
            if((end - start + 1) < k){
                end++;
            }
            else if((end - start + 1) == k){
                ans[i++] = deque.peekFirst();
                
                if(nums[start] == deque.peekFirst()){
                    deque.removeFirst();
                }
                
                start++;
                end++;
            }
        }
        
        return ans;
    }
}