class Solution {
    public boolean isMatch(String str, String pattern) {
        int m = pattern.length();
        int n = str.length();
        
        int[][] dp = new int[m+1][n+1];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        
        return check(m-1, n-1, pattern, str, dp);
    }
    
    boolean check(int i, int j,String pattern,String str, int[][] dp){
        if(i < 0 && j < 0){
            return true;
        }
        if(i < 0 && j >= 0){
            return false;
        }
        if(j < 0 && i >= 0){
            for(int k=0; k<=i; k++){
                if(pattern.charAt(k) != '*'){
                    return false;
                }
            }
            return true;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j] == 1;
        }
        
        if(pattern.charAt(i) == str.charAt(j) || pattern.charAt(i) == '?'){
            dp[i][j] = check(i-1, j-1, pattern, str, dp) ? 1 : 0;
        }
        else if(pattern.charAt(i) == '*'){
            dp[i][j] = check(i-1, j, pattern, str, dp) || check(i, j-1, pattern, str, dp) ? 1 : 0;
        }
        else{
            dp[i][j] = 0;
        }
        return dp[i][j] == 1;
    }
}