class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        
        int[][] dp = new int[n][n];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            min = Math.min(min, getMinFallingPathSum(0, i, matrix, dp));
        }
        return min;
    }
    
    int getMinFallingPathSum(int row, int col, int[][] matrix, int[][] dp){
if(!(row >= 0 && col >= 0 && row < matrix.length && col < matrix.length)){
            return Integer.MAX_VALUE - 132344;
        }
        
        if(row == matrix.length - 1){
            return matrix[row][col];
        }
        
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        
        int down = matrix[row][col] + getMinFallingPathSum(row+1, col, matrix, dp);
        int leftDiagonal = matrix[row][col] + getMinFallingPathSum(row+1, col-1, matrix, dp);
        int rightDiagonal = matrix[row][col] + getMinFallingPathSum(row+1, col+1, matrix, dp);
        
        dp[row][col] = Math.min(down, Math.min(leftDiagonal, rightDiagonal));
        return dp[row][col];
    }
}