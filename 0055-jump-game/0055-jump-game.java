class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        
        dp[n-1] = true;
        
        for(int i=n-2; i>=0; i--){
            if(nums[i] == 0){
                dp[i] = false;
                continue;
            }
            int maxJump = i + nums[i];
            boolean flag = false;
            for(int jump = i+1; jump <= maxJump; jump++){
                if(jump < nums.length && dp[jump]){
                    flag = true;
                    dp[i] = true;
                    break;
                }
            }
            
            if(flag){
               continue; 
            }
            dp[i] = false;
        }
        
        return dp[0];
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