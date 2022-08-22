class Solution {
    public int longestOnes(int[] nums, int k) {

        int start =0, end =0;
        int ans = -1;
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
        
        if(ans == -1){
            if(k == 0){
                return 0;
            }
            else{
                return nums.length;
            }
        }
        return ans;
    }
}