class Solution {
    public int longestCommonSubsequence(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        
        for(int i=0; i<=str1.length(); i++){
            dp[i][0] = 0;
        }
        for(int j=0; j<=str2.length(); j++){
            dp[0][j] = 0;
        }
        
        for(int i=1; i<=str1.length(); i++){
            for(int j=1; j<=str2.length(); j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    int left = dp[i-1][j];
                    int right = dp[i][j-1];
            
                    dp[i][j] = Math.max(left, right);
                }
            }
        }
        
        return dp[str1.length()][str2.length()]; //getLongestCommonSubsequence(str1.length(), str2.length(), str1, str2, dp);
    }
    
    int getLongestCommonSubsequence(int i, int j, String str1, String str2, int[][] dp){
        if(i == 0 || j == 0){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        if(str1.charAt(i-1) == str2.charAt(j-1)){
            dp[i][j] = 1 + getLongestCommonSubsequence(i-1, j-1, str1, str2, dp);
        }
        else{
            int left = getLongestCommonSubsequence(i-1, j, str1, str2, dp);
            int right = getLongestCommonSubsequence(i, j-1, str1, str2, dp);
            
            dp[i][j] = Math.max(left, right);
        }
        
        return dp[i][j];
    }
}