class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        
        for(int i=1; i<n; i++){
            int pick = nums[i];
            if((i-2) >= 0){
                pick += dp[i-2];
            }
            int notPick = dp[i-1];
            
            dp[i] = Math.max(pick, notPick);
        }
        
        return dp[n-1];
    }
}