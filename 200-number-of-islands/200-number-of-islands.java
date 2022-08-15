class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        int[] delRow =  new int[]{-1, 0, 1, 0};
        int[] delCol =  new int[]{0, 1, 0, -1};
        for(int i =0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j, visited, delRow, delCol);
                }
            }
        }
        
        return count;
    }
    
    void dfs(char[][] grid,int r, int c,boolean[][] visited,int[] delRow,int[] delCol){
        visited[r][c] = true;
        
        for(int i=0; i<4; i++){
            int newRow = r + delRow[i];
            int newCol = c + delCol[i];
            if(isValid(newRow, newCol, grid) && !visited[newRow][newCol] && grid[newRow][newCol] == '1'){
                dfs(grid, newRow, newCol, visited, delRow, delCol);
            }
        }
    }
    
    boolean isValid(int r, int c, char[][] grid){
        if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length){
            return true;
        }
        
        return false;
    }
}