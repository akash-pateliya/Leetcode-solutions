class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        int[][] dp = new int[coins.length][amount+1];
        
        for(int i=0; i<=amount; i++){
            dp[0][i] = i % coins[0] == 0 ? i / coins[0] : 1000000;
        }
        
        for(int i = 1; i<coins.length; i++){
            for(int j = 0; j<=amount; j++){
                int exclude = dp[i - 1][j];
                int include = 1000000;
                if(j - coins[i] >= 0){
                    include = 1 + dp[i][j - coins[i]];
                }

                dp[i][j] = Math.min(include, exclude);
            }
        }
        
        int ans = dp[coins.length - 1][amount]; //getMinCoins(coins.length - 1, amount, coins, dp);
        if(ans == 1000000){
            return -1;
        }
        return ans;
    }
    
    int getMinCoins(int idx, int amount, int[] coins, int[][] dp){
        if(idx == 0){
            if(amount % coins[0] == 0){
                return amount / coins[0];
            }
            
            return 1000000;
        }
        
        if(dp[idx][amount] != -1){
            return dp[idx][amount];
        }
        
        int exclude = getMinCoins(idx - 1, amount, coins, dp);
        int include = 1000000;
        if(amount - coins[idx] >= 0){
            include = 1 + getMinCoins(idx, amount - coins[idx], coins, dp);
        }
        
        dp[idx][amount] = Math.min(include, exclude);
        return dp[idx][amount];
    }
}