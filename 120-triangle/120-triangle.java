class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.size();
        
        int[][] dp = new int[m][n];
        
        for(int i=0; i<m; i++){
            dp[n-1][i] = triangle.get(n-1).get(i);
        }
        
        for(int row=m-2; row >= 0; row--){
            for(int col = row; col >= 0; col--){
                int down = triangle.get(row).get(col) + dp[row+1][col];
                int diagonal = triangle.get(row).get(col) + dp[row+1][col+1];
                
                dp[row][col] = Math.min(down, diagonal);
            }
        }
        
        return dp[0][0];
    }
    
    int getMinTotal(int row, int col, int n, List<List<Integer>> triangle, int[][] dp){
        if(row == n -1){
            return triangle.get(row).get(col);
        }
        
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        
        int down = triangle.get(row).get(col) + getMinTotal(row+1, col,n, triangle, dp);
        int diagonal = triangle.get(row).get(col) + getMinTotal(row+1, col+1, n, triangle, dp);
        
        dp[row][col] = Math.min(down, diagonal);
        
        return dp[row][col];
    }
}