class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i=0; i<=amount; i++){
            dp[0][i] = i % coins[0] == 0 ? 1 : 0; 
        }
        
        for(int i=1; i<coins.length; i++){
            for(int j=0; j<=amount; j++){
                int exclude = dp[i - 1][j];
                int include = 0;
                if(j >= coins[i]){
                    include = dp[i][j - coins[i]];
                }
        
                dp[i][j] = include + exclude;
            }
        }
        
        return dp[coins.length - 1][amount];
        // return getTotalWays(coins.length -1, amount, coins, dp);
    }
    
    int getTotalWays(int idx, int amount, int[] coins, int[][] dp){
        if(idx == 0){
            if(amount % coins[0] == 0){
                return 1;
            }
            return 0;
        }
        
        if(dp[idx][amount] != -1){
            return dp[idx][amount];
        }
        
        int exclude = getTotalWays(idx - 1, amount, coins, dp);
        int include = 0;
        if(amount >= coins[idx]){
            include = getTotalWays(idx, amount - coins[idx], coins, dp);
        }
        
        dp[idx][amount] = include + exclude;
        
        return dp[idx][amount];
    }
}