class Solution {
    public boolean isMatch(String str, String pattern) {
        int m = pattern.length();
        int n = str.length();
        
        int[][] dp = new int[m+1][n+1];
        
        dp[0][0] = 1;
        
        for(int i=1; i<=n; i++){
            dp[0][i] = 0;
        }
        
        for(int i=1; i<=m ; i++){
            boolean flag = true;
            for(int k=1; k<=i; k++){                
                if(pattern.charAt(k-1) != '*'){
                    flag = false;
                    break;
                }
            }
            dp[i][0] = flag ? 1: 0;
        }
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(pattern.charAt(i-1) == str.charAt(j-1) || pattern.charAt(i-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(pattern.charAt(i-1) == '*'){
                    dp[i][j] = dp[i-1][j] == 1 || dp[i][j-1] == 1 ? 1 : 0;
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        
        return dp[m][n] == 1; //check(m, n, pattern, str, dp);
    }
    
    boolean check(int i, int j,String pattern,String str, int[][] dp){
        if(i == 0 && j == 0){
            return true;
        }
        if(i == 0 && j > 0){
            return false;
        }
        if(j == 0 && i > 0){
            for(int k=1; k<=i; k++){
                if(pattern.charAt(k-1) != '*'){
                    return false;
                }
            }
            return true;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j] == 1;
        }
        
        if(pattern.charAt(i-1) == str.charAt(j-1) || pattern.charAt(i-1) == '?'){
            dp[i][j] = check(i-1, j-1, pattern, str, dp) ? 1 : 0;
        }
        else if(pattern.charAt(i-1) == '*'){
            dp[i][j] = check(i-1, j, pattern, str, dp) || check(i, j-1, pattern, str, dp) ? 1 : 0;
        }
        else{
            dp[i][j] = 0;
        }
        return dp[i][j] == 1;
    }
}