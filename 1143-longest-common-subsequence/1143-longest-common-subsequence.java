class Solution {
    public int longestCommonSubsequence(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return getLongestCommonSubsequence(str1.length(), str2.length(), str1, str2, dp);
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