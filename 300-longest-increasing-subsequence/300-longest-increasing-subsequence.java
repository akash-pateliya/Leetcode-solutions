class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return getMaxLen(0, -1, nums, dp);
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