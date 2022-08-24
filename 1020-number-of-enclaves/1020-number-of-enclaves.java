class Solution {
    public int numEnclaves(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        int n = grid.length;
        int m = grid[0].length;
        
        int[] di = new int[]{-1, 0, 1, 0};
        int[] dj = new int[]{0, 1, 0, -1};
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(isBoundry(i, j, n,m) && !visited[i][j] && grid[i][j] == 1){
                    dfs(i, j, grid, visited, di, dj);
                }
            }
        }
        
        int ans = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    ans++;
                }
            }
        }
        
        return ans;
    }
    
    void dfs(int r, int c, int[][] grid, boolean[][] visited,int[] di, int[] dj){
        visited[r][c] = true;
        grid[r][c] = 0;
        
        for(int i=0; i<4; i++){
            int row = r + di[i];
            int col = c + dj[i];
            
            if(isValid(row, col, grid) && !visited[row][col] && grid[row][col] == 1){
                dfs(row, col, grid, visited, di, dj);
            }
        }
    }
    
    boolean isValid(int r, int c, int[][] arr){
        return (r >= 0 && c >= 0 && r < arr.length && c < arr[0].length);
        
    }
    boolean isBoundry(int r, int c, int n, int m){
        return r == 0 || c == 0 || r == n - 1 || c == m-1;
    }
}