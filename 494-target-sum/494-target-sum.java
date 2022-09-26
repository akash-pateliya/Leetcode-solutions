class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = Arrays.stream(nums).sum();
        if(total < target){
            return 0;
        }
        int[][] dp = new int[nums.length][total + 1];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return distinctExpression(nums.length - 1, 0, total, target, nums, dp);
    }
    
    int distinctExpression(int idx, int currentSum, int total,int target, int[] nums, int[][] dp){
        if(idx < 0){
            if(currentSum - (total - currentSum) == target){
                return 1;
            }
            return 0;
        }
        
        if(dp[idx][currentSum] != -1){
           return dp[idx][currentSum]; 
        }
        
        int notPick = distinctExpression(idx-1, currentSum, total, target, nums, dp);
        int pick = distinctExpression(idx-1, currentSum + nums[idx], total, target, nums, dp);
        
        dp[idx][currentSum] = pick + notPick;
        return dp[idx][currentSum];
    }
}