class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int ans1 = getMax(nums, 0, nums.length-2);
        int ans2 = getMax(nums, 1, nums.length-1);
        
        return Math.max(ans1, ans2);
    }
    
    int getMax(int[] arr, int start, int end){
        int[] dp = new int[arr.length];
        dp[start] = arr[start];
        
        for(int i=start+1; i<=end; i++){
            int pick = arr[i];
            if((i-2) >= 0){
                pick += dp[i-2];
            }
            int notPick = dp[i-1];
            
            dp[i] = Math.max(pick, notPick);
        }
        
        return dp[end];
    }
}