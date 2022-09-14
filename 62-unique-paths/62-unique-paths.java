class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i == 0 && j==0){
                    dp[i][j] = 1;
                }
                else{
                int left = 0, right = 0;
                //go down
                if(isValid(i-1, j, m, n)){
                    left = dp[i-1][j];
                }
                //go right
                if(isValid(i, j-1, m, n)){
                    right = dp[i][j-1];
                } 
                dp[i][j] = left+right;

                }
            }
        }
        
        return dp[m-1][n-1];
    }
    
    boolean isValid(int r, int c, int m, int n){
        return (r >= 0 && c >= 0 && r < m && c < n);
    }
}