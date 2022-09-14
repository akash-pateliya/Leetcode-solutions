class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        
        if(m == 1 && n == 1){
            return grid[0][0];
        }
        
        for(int row=0; row<m; row++){
            for(int col=0; col<n; col++){
                if(row == 0 && col == 0){
                    dp[row][col] = grid[0][0];
                }
                else{
                    int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
                    
                    if(row - 1 >= 0){
                        up = dp[row-1][col];
                    }
                    if(col - 1 >= 0){
                        left = dp[row][col-1];
                    }
                    
                    dp[row][col] = Math.min(up, left) + grid[row][col]; 
                }
            }
        }
        
        return dp[m-1][n-1];
    }
    
    int getMinPathSum(int row, int col, int[][] grid, int[][] dp){
        if(row == 0 && col == 0){
            return grid[0][0];
        }
        if(row < 0 || col < 0){
            return Integer.MAX_VALUE;
        }
        
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        
        int up = getMinPathSum(row-1, col, grid, dp);
        int left = getMinPathSum(row, col-1, grid, dp);
        
        dp[row][col] = Math.min(up, left) + grid[row][col]; 
        
        return dp[row][col];
    }
}