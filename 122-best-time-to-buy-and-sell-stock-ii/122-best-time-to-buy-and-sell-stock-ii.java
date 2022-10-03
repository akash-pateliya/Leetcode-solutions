class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        
        for(int[] arr: dp)
            Arrays.fill(arr, -1);
        
        return getMaxProfit(0, 1, prices, dp);
    }
    
    int getMaxProfit(int i, int buy,int[] prices, int[][] dp){
        if(i == prices.length){
            return 0;
        }
        
        if(dp[i][buy] != -1)
            return dp[i][buy];
        
        if(buy == 1){
            int includeBuy = -prices[i] + getMaxProfit(i+1, 0, prices, dp);
            int excludeBuy = getMaxProfit(i+1, 1, prices, dp);
            
            dp[i][buy] = Math.max(includeBuy, excludeBuy);
        }
        else{
            int includeSell = prices[i] + getMaxProfit(i+1, 1, prices, dp);
            int excludeSell = getMaxProfit(i+1, 0, prices, dp);
            
            dp[i][buy] = Math.max(includeSell, excludeSell);
        }
        
        return dp[i][buy];
    }
}