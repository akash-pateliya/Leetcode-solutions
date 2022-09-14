class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        
        if(m == 1 && n == 1){
            return grid[0][0];
        }
        
        return getMinPathSum(m-1, n-1, grid, dp);
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