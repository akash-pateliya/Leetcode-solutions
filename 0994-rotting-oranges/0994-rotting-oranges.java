class Solution {
    class Tuples{
        int row;
        int col;
        int time;
        
        Tuples(int r, int c, int t){
            row = r;
            col = c;
            time = t;
        }
    }
    public int orangesRotting(int[][] grid) {
        int rowlength = grid.length;
        int colLength = grid[0].length;
        
        int[] delRow = new int[]{-1, 0, 1, 0};
        int[] delCol = new int[]{0, 1, 0, -1};
        
        int freshCount = 0;
        Queue<Tuples> queue = new LinkedList<>();
        
        for(int row=0; row < rowlength; row++){
            for(int col=0; col < colLength; col++){
                if(grid[row][col] == 2){
                    queue.add(new Tuples(row, col, 0));
                }
                else if(grid[row][col] == 1){
                    freshCount++;
                }
            }
        }
        
        int time = 0;
        
        while(!queue.isEmpty()){
            Tuples top = queue.remove();
            time = Math.max(time, top.time);
            
            for(int i=0; i<4; i++){
                int newRow  = delRow[i] + top.row;
                int newCol  = delCol[i] + top.col;

                if(isValid(newRow, newCol, grid) && grid[newRow][newCol] == 1){
                    freshCount--;
                    grid[newRow][newCol] = 2;
                    queue.add(new Tuples(newRow, newCol, top.time+1));
                }
            }
        }
        
        if(freshCount != 0){
            return -1;
        }
        
        return time;
    }
    
    boolean isValid(int r, int c,int[][] grid){
        return r >= 0 && c >= 0 && r < grid.length && c < grid[0].length;
    }
}