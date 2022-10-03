class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        
        for(int i=1; i<prices.length; i++){
            int newProfit = prices[i] - min;
            profit = Math.max(profit, newProfit);
            min = Math.min(min, prices[i]);
        }
        
        return profit;
    }
}