class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int start=0, end=0;
        int oddCount = 0;
        int ans = 0;
        int count = 0;
        
        while(end < nums.length){
            if(nums[end] % 2 != 0){
                oddCount++;
                count = 0;
            }
            
            while(oddCount == k){
                count++;
                if(nums[start] % 2 != 0){
                    oddCount--;
                }
                start++;
            }
            
            ans = ans + count;
            end++;
        }
        
        return ans;
    }
}