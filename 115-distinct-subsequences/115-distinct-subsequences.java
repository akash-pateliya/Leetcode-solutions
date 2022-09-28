class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        int[][] dp = new int[m+1][n+1];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return getDistinctSubsequence(s.length(), t.length(), s, t, dp);
    }
    
    int getDistinctSubsequence(int i, int j, String s, String t, int[][] dp){
        if(j == 0){
            return 1;
        }
        if(i == 0){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        if(s.charAt(i-1) == t.charAt(j-1)){
            dp[i][j] = getDistinctSubsequence(i-1, j, s, t, dp) + getDistinctSubsequence(i-1, j-1, s, t, dp);
        }
        else{
            dp[i][j] = getDistinctSubsequence(i-1, j, s, t, dp);
        }
        
        return dp[i][j];
    }
}