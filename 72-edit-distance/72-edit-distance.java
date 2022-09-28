class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] dp = new int[m+1][n+1];
        
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        
        return getMin(m-1, n-1, word1, word2, dp);
    }
    
    int getMin(int i, int j, String word1, String word2, int[][] dp){
        
        if(i<0){
            return j+1;
        }
        if(j<0){
            return i+1;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        if(word1.charAt(i) == word2.charAt(j)){
            dp[i][j] = getMin(i-1, j-1, word1, word2, dp);
            return dp[i][j];
        }
        else{
            int insert = 1 + getMin(i, j-1, word1, word2, dp);
            int replace = 1 + getMin(i-1, j-1, word1, word2, dp);
            int remove = 1 + getMin(i-1, j, word1, word2, dp);
            
            dp[i][j] = Math.min(insert, Math.min(replace, remove));
            return dp[i][j];
        }
    }
}