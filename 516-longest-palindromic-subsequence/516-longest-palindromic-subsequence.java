class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String str1 = s;
        String str2 = sb.toString();
        
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
        
        return dp[str1.length()][str2.length()];
    }
}