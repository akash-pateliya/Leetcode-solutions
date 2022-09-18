class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][][] dp = new int[m][n][n];
        
        for(int[][] TwoDimarr: dp){
            for(int[] OneDimArr: TwoDimarr){
                Arrays.fill(OneDimArr, -1);
            }
        }
        
        return maxChocolatesCount(0, 0, n-1, grid, dp);
    }
    int maxChocolatesCount(int row, int col1,int col2,int[][] grid, int[][][] dp){
        if(!(col1 >= 0 && col2 >= 0 && col1 < grid[0].length && col2 < grid[0].length)){
            return -1;
        } 
        
        if(row == grid.length - 1){
            if(col1 == col2){
                return grid[row][col1];
            }
            else{
                return grid[row][col1] + grid[row][col2];
            }
        }
        
        if(dp[row][col1][col2] != -1){
            return dp[row][col1][col2];
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=-1; i<2; i++){
            for(int j=-1; j<2; j++){
                if(col1 == col2){
                    max = Math.max(max,grid[row][col1] + maxChocolatesCount(row+1, col1+i, col2+j, grid, dp));
                }
                else{
                    max = Math.max(max, grid[row][col1] + grid[row][col2] + maxChocolatesCount(row+1, col1+i, col2+j, grid, dp));
                }
            }
        }
        dp[row][col1][col2] = max;
        return dp[row][col1][col2];
    }
}