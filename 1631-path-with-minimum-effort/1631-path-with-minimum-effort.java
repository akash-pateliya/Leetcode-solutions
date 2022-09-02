class Solution {
    class Pair{
        int row;
        int col;
        
        Pair(int r, int c){
            row = r;
            col = c;
        }
    }
    public int minimumEffortPath(int[][] grid) {
        int max = Integer.MIN_VALUE;
        for(int[] arr: grid){
            for(int n: arr){
                max = Math.max(n, max);
            }
        }
        int start = 0, end = max;
        while(start < end){
            int mid = start + (end - start) / 2;
            
            boolean status = hasPath(mid, grid);
            
            if(status){
                end = mid;
            }
            else{
                start = mid+1;
            }
        }
        
        return start;
    }
    
    boolean hasPath(int max, int[][] grid){
        Queue<Pair> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        queue.add(new Pair(0, 0));
        visited[0][0] = true;
        
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};
        
        while(!queue.isEmpty()){
            Pair top = queue.remove();
            
            if(top.row == grid.length - 1 && top.col == grid[0].length - 1){
                return true;
            }
            
            for(int i=0; i<4; i++){
                int r = top.row + di[i];
                int c = top.col + dj[i];
                
                if(isValid(r, c, grid) && !visited[r][c] && max >= Math.abs(grid[r][c] - grid[top.row][top.col])){
                    visited[r][c] = true;
                    queue.add(new Pair(r, c));
                }
            }
        }
        
        return false;
    }
    
    boolean isValid(int r, int c, int[][] grid){
        return (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length);
    }
}