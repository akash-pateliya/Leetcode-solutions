class Solution {
    public int longestOnes(int[] nums, int k) {

        int start =0, end =0;
        int ans = 0;
        int count = 0;
        while(end < nums.length){
            if(nums[end] == 0){
                count++;
            }
            
            if(count <= k){
                ans = Math.max(ans, (end - start + 1));
            }
            else if(count > k){
                    if(nums[start] == 0){
                        count--;
                    }
                    start++;
            }
            
            end++;
        }
        
        return ans;
    }
}