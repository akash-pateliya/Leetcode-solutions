class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1){
            return 0;
        }
        if(m == 1 && n == 1){
            return obstacleGrid[0][0] == 0 ? 1 : 0;
        }
        
        int[][] dp = new int[m][n];
        
        for(int row=0; row<m; row++){
            for(int col=0; col<n; col++){
                if(row == 0 && col == 0){
                    dp[row][col] = 1;
                }
                else{
                    int down = 0, right =0;
                    if((row - 1) >= 0 && obstacleGrid[row-1][col] == 0){
                        down = dp[row-1][col];
                    }
                    if((col - 1) >= 0 && obstacleGrid[row][col-1] == 0){
                        right = dp[row][col-1];
                    }
                    dp[row][col] = down+right;
                }
            }
        }
        return dp[m-1][n-1];
    }
    
}