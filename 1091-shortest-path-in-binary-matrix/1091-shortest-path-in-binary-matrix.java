class Solution {
    class Pair{
        int row;
        int col;
        
        Pair(int r, int c){
            this.row = r;
            this.col = c;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        if(m == 0 || n == 0 || grid[0][0] == 1 || grid[m-1][n-1] == 1){
            return -1;
        }
        
        int ans = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<Pair> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.add(new Pair(0, 0));
        
        while(!queue.isEmpty()){
            int size = queue.size();
            ans++;
            for(int k=0; k<size; k++){
                Pair top = queue.remove();
                
                if(top.row == m-1 && top.col == n-1){
                    return ans;
                }
                
                for(int i=-1; i<=1; i++){
                    for(int j=-1; j<=1; j++){
                        int r = top.row + i;
                        int c = top.col + j;
                        if(isValid(r, c, grid) && !visited[r][c] && grid[r][c] == 0){
                            visited[r][c] = true;
                            queue.add(new Pair(r, c));
                        }
                    }
                }
            }
        }
        
        return -1;
    }
    
    boolean isValid(int r, int c, int[][] grid){
        return (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length);
    }
}