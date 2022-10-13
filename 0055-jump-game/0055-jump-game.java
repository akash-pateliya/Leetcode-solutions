class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        
        return isPossible(0, nums, dp);
    }
    
    boolean isPossible(int i, int[] nums, int[] dp){
        if(i == nums.length - 1){
            return true;
        }
        
        if(nums[i] == 0){
            return false;
        }
        
        if(dp[i] != -1){
            return dp[i] == 1;
        }
        
        int maxJump = i + nums[i];
        
        for(int jump = i+1; jump <= maxJump; jump++){
            if(jump < nums.length && isPossible(jump, nums, dp)){
                dp[i] = 1;
                return true;
            }
        }
        dp[i] = 0;
        return false;
    }
}