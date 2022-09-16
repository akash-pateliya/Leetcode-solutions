class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.size();
        
        int[][] dp = new int[m][n];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        
        return getMinTotal(0, 0, n, triangle, dp);
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