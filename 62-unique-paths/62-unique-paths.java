class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = -1;
            }
        }
        return countUniquePath(0, 0, m,n, dp);
    }
    
    int countUniquePath(int row, int col, int m, int n, int[][] dp){
        if(row == m-1 && col == n-1){
            return 1;
        }
        
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int left = 0, right = 0;
        //go down
        if(isValid(row+1, col, m, n)){
            left = countUniquePath(row+1, col, m, n, dp);
        }
        //go right
        if(isValid(row, col+1, m, n)){
            right = countUniquePath(row, col+1, m, n, dp);
        }
        dp[row][col] = left+right;
        return dp[row][col];
    }
    
    boolean isValid(int r, int c, int m, int n){
        return (r >= 0 && c >= 0 && r < m && c < n);
    }
}