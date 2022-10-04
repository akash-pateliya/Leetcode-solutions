class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];
  
        
        for(int i=nums.length-1; i >= 0; i--){
            for(int prev=i-1; prev >= -1; prev--){
                int len = dp[i+1][prev+1];
                if(prev == -1 || nums[i] > nums[prev]){
                    len = Math.max(len,1 + dp[i+1][i+1]);
                }

                dp[i][prev+1] = len;
            }
        }
        
        return dp[0][0];
    }
    
    int getMaxLen(int i,int prev,int[] nums, int[][] dp){
        if(i == nums.length){
            return 0;
        }
        
        if(dp[i][prev+1] != -1){
            return dp[i][prev+1];
        }
        
        int len = getMaxLen(i+1, prev, nums, dp);
        if(prev == -1 || nums[i] > nums[prev]){
            len = Math.max(len,1 + getMaxLen(i+1, i, nums, dp));
        }
        
        dp[i][prev+1] = len;
        
        return dp[i][prev+1];
    }
}