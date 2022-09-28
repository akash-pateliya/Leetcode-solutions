class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i=0; i<=m; i++){
            dp[i][0] = i;
        }
        
        for(int i=0; i<=n; i++){
            dp[0][i] = i;
        }
        
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int insert = dp[i][j-1];
                    int replace = dp[i-1][j-1];
                    int remove = dp[i-1][j];

                    dp[i][j] = 1 + Math.min(insert, Math.min(replace, remove));
                }
            }
        }
        return dp[m][n]; //getMin(m, n, word1, word2, dp);
    }
    
    int getMin(int i, int j, String word1, String word2, int[][] dp){
        
        if(i == 0){
            return j;
        }
        if(j == 0){
            return i;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        if(word1.charAt(i-1) == word2.charAt(j-1)){
            dp[i][j] = getMin(i-1, j-1, word1, word2, dp);
            return dp[i][j];
        }
        else{
            int insert = getMin(i, j-1, word1, word2, dp);
            int replace = getMin(i-1, j-1, word1, word2, dp);
            int remove = getMin(i-1, j, word1, word2, dp);
            
            dp[i][j] = 1 + Math.min(insert, Math.min(replace, remove));
            return dp[i][j];
        }
    }
}