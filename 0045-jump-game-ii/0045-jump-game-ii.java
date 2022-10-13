class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return minJump(0, nums, dp);
    }
    
    int minJump(int i, int[] nums, int[] dp){
        if(i == nums.length - 1){
            return 0;
        }
        
        if(nums[i] == 0){
            return 10000;
        }
        
        if(dp[i] != -1){
            return dp[i];
        }
        
        int maxJump = i + nums[i];
        int min = Integer.MAX_VALUE;
        for(int jump = i+1; jump <= maxJump; jump++){
            if(jump < nums.length){
                min = Math.min(min,1 + minJump(jump, nums, dp));
            }
        }
        
        dp[i] = min;
        return dp[i];
    }
}