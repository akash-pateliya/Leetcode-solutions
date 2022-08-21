class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0;
        int sum = nums[end];
        int minWindowSize = Integer.MAX_VALUE;
        
        while(end < nums.length){
            if(target > sum){
                end++;
                if(end < nums.length){
                    sum = sum + nums[end];
                }
            }
            else{
                minWindowSize = Math.min(minWindowSize, (end - start + 1));
                sum = sum - nums[start];
                start++;
            }
        }
        
        if(minWindowSize == Integer.MAX_VALUE){
            return 0;
        }
        return minWindowSize;
    }
}