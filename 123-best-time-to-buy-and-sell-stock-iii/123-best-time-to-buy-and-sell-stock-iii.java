class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        

        int[][][] dp = new int[prices.length+1][2][3];
        
        for(int i=0; i<n; i++){
            for(int j = 0; j<=1; j++){
                dp[i][j][0] = 0;
            }
        }
        
        for(int i=0; i<=1; i++){
            for(int j=0; j<=2; j++){
                dp[n][i][j] = 0;
            }
        }
        
        for(int i=n-1; i >= 0; i--){
            for(int buy=0; buy<=1; buy++){
                for(int totalTrasaction=1; totalTrasaction <= 2; totalTrasaction++){
                    if(buy == 1){
                        int includeBuy = -prices[i] + dp[i+1][0][totalTrasaction];
                        int excludeBuy = dp[i+1][1][totalTrasaction];

                        dp[i][buy][totalTrasaction] = Math.max(includeBuy, excludeBuy);
                    }
                    else{
                        int includeSell = prices[i] + dp[i+1][1][totalTrasaction-1];
                        int excludeSell = dp[i+1][0][totalTrasaction];

                        dp[i][buy][totalTrasaction] = Math.max(includeSell, excludeSell);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
    
    int getMaxProfit(int i, int buy,int totalTrasaction, int[] prices, int[][][] dp){
        if(i == prices.length || totalTrasaction == 0){
            return 0;
        }
        
        if(dp[i][buy][totalTrasaction] != -1)
            return dp[i][buy][totalTrasaction];
        
        if(buy == 1){
            int includeBuy = -prices[i] + getMaxProfit(i+1, 0,totalTrasaction, prices, dp);
            int excludeBuy = getMaxProfit(i+1, 1,totalTrasaction, prices, dp);
            
            dp[i][buy][totalTrasaction] = Math.max(includeBuy, excludeBuy);
        }
        else{
            int includeSell = prices[i] + getMaxProfit(i+1, 1,totalTrasaction-1, prices, dp);
            int excludeSell = getMaxProfit(i+1, 0,totalTrasaction, prices, dp);
            
            dp[i][buy][totalTrasaction] = Math.max(includeSell, excludeSell);
        }
        
        return dp[i][buy][totalTrasaction];
    }
}