class Solution {
    class Tuples{
        int row;
        int col;
        int dist;
        
        Tuples(int a, int b, int c){
            row = a;
            col = b;
            dist = c;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        
        Queue<Tuples> queue = new LinkedList<>();
        
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 0){
                    queue.add(new Tuples(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        
        int[] di = new int[]{-1, 0, 1, 0};
        int[] dj = new int[]{0, 1, 0, -1};
        
        while(!queue.isEmpty()){
            Tuples top = queue.remove();
            res[top.row][top.col] = top.dist;
            
            for(int i=0; i<4; i++){
                int row = top.row + di[i];
                int col = top.col + dj[i];
                
                if(isValid(row, col, mat) && !visited[row][col]){
                    visited[row][col] = true;
                    queue.add(new Tuples(row, col, top.dist + 1));
                }
            }
        }
        
        
        return res;
    }
    
    boolean isValid(int r, int c, int[][] arr){
        if(r >= 0 && c >= 0 && r < arr.length && c < arr[0].length){
            return true;
        }
        
        return false;
    }
}