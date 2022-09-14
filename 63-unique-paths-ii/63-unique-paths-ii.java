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
        
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        
        return countUniquePathsWithObstacles(m-1, n-1, obstacleGrid, dp);
    }
    
    int countUniquePathsWithObstacles(int row, int col, int[][] obstacleGrid, int[][] dp){
        if(row == 0 && col == 0){
            return 1;
        }
        if(row < 0 || col < 0 || obstacleGrid[row][col] == 1){
            return 0;
        }
        
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        
        int down = countUniquePathsWithObstacles(row - 1, col, obstacleGrid, dp);
        int right = countUniquePathsWithObstacles(row, col-1, obstacleGrid, dp);
        
        dp[row][col] = down+right;
        
        return dp[row][col];
    }
}