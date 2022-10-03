class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length+1][2][3];
        
        for(int[][] twoD: dp){
            for(int[] oneD: twoD){
                Arrays.fill(oneD, -1);
            }
        }
        
        return getMaxProfit(0, 1, 2, prices, dp);
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