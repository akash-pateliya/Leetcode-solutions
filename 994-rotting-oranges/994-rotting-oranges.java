class Solution {
    class Tuples{
        int row;
        int col;
        int time;
        
        Tuples(int r, int c, int t){
            this.row = r;
            this.col = c;
            this.time = t;
        }
    }
    public int orangesRotting(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Tuples> queue = new LinkedList<>();
        int freshCount = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.add(new Tuples(i, j, 0));
                }
                
                if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }
        int time = 0;
        
        int[] delRow = new int[]{-1, 0, 1, 0};
        int[] delCol = new int[]{0, 1, 0, -1};
        
        while(!queue.isEmpty()){
            Tuples top = queue.remove();
            time = Math.max(time, top.time);
            
            for(int i=0; i<4; i++){
                int r = top.row + delRow[i];
                int c = top.col + delCol[i];
                
                if(isValid(r, c, grid) && grid[r][c] == 1){
                    grid[r][c] = 2;
                    freshCount--;
                    queue.add(new Tuples(r, c, top.time + 1));
                }
            }
        }
        
        if(freshCount != 0){
            return -1;
        }
        
        return time;
    }
    
    boolean isValid(int r, int c, int[][] grid){
        if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length){
            return true;
        }
        
        return false;
    }
}