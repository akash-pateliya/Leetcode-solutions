class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        

        int[][][] dp = new int[prices.length+1][2][k+1];
        
        for(int i=0; i<n; i++){
            for(int j = 0; j<=1; j++){
                dp[i][j][0] = 0;
            }
        }
        
        for(int i=0; i<=1; i++){
            for(int j=0; j<=k; j++){
                dp[n][i][j] = 0;
            }
        }
        
        for(int i=n-1; i >= 0; i--){
            for(int buy=0; buy<=1; buy++){
                for(int totalTrasaction=1; totalTrasaction <= k; totalTrasaction++){
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
        return dp[0][1][k];
    }
}