class Solution {
    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
        
        for(int[][] twoD: dp){
            for(int[] oneD: twoD){
                Arrays.fill(oneD, -1);
            }
        }
        int ans = maxChocolatesCount(0, 0, 0, grid, dp); 
        return ans<0?0:ans;
    }
    int maxChocolatesCount(int row1,int col1, int row2,int[][] grid, int[][][] dp){
        int col2 = row1+col1 - row2;
        if(!isValid(row1, col1, grid) || !isValid(row2, col2, grid)){
            return Integer.MIN_VALUE;
        }
        
        
        if((row1 == grid.length - 1 && col1 == grid[0].length - 1)){
            return grid[row1][col1];
        }
        
        if(dp[row1][col1][row2] != -1){
            return dp[row1][col1][row2];
        }
        
        int ans = 0;
        if((row1==row2) && (col1==col2)){
            ans = grid[row1][col1];
        }
        else{
            ans = grid[row1][col1] + grid[row2][col2];
        }
        int rr = maxChocolatesCount(row1, col1+1, row2, grid, dp);
        int dd = maxChocolatesCount(row1+1, col1, row2+1,grid, dp);
        int rd = maxChocolatesCount(row1, col1+1, row2+1, grid, dp);
        int dr = maxChocolatesCount(row1+1, col1, row2, grid, dp);
        
        int max = Math.max(Math.max(rr, dd), Math.max(dr, rd));
        dp[row1][col1][row2] = max+ans;
        return max + ans;
    }
    
    boolean isValid(int r, int c, int[][] grid){
        return (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] != -1);
    }
}