class Solution {
    public boolean canPartition(int[] nums) {
        int targetSum = Arrays.stream(nums).sum();
        if(targetSum % 2 != 0){
            return false;
        }
        boolean[][] dp = new boolean[nums.length + 1][targetSum + 1];
        // for(int[] arr: dp){
        //     Arrays.fill(arr, -1);
        // }
        
        for(int i=0; i<nums.length; i++){
            dp[i][0] = true;
        }
        
        for(int i=0; i<=targetSum/2; i++){
            dp[0][i] = nums[0] == i;
        }
        
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<targetSum/2 + 1; j++){
                boolean notPick = dp[i-1][j];
                boolean pick = false;
                if(!notPick && j - nums[i] >= 0)
                    pick = dp[i-1][j - nums[i]];
        
                dp[i][j] = pick || notPick;
            }
        }
        
        return dp[nums.length - 1][targetSum/2]; //isExists(nums.length - 1,targetSum/2, nums, dp);
    }
    
    boolean isExists(int idx,int targetSum,int[] nums, int[][] dp){
        if(targetSum == 0){
            return true;
        }
        
        if(idx == 0){
            return nums[0] == targetSum;
        }
        
        if(dp[idx][targetSum] != -1){
            return dp[idx][targetSum] == 1;
        }
        
        boolean notPick = isExists(idx-1,targetSum, nums, dp);
        boolean pick = false;
        if(!notPick && targetSum - nums[idx] >= 0)
            pick = isExists(idx-1,targetSum - nums[idx], nums, dp);
        
        dp[idx][targetSum] = pick || notPick ? 1 : 0;
        
        return pick || notPick;
    }
}