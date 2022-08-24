class Solution {
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        int[] di = new int[]{-1, 0, 1, 0};
        int[] dj = new int[]{0, 1, 0, -1};
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(!visited[i][j] && board[i][j] == 'O' && (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1)){
                    dfs(i, j, board, visited, di, dj);
                }
            }
        }
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 'A'){
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    void dfs(int r, int c, char[][] board, boolean[][] visited, int[] di, int[] dj){
        visited[r][c] = true;
        board[r][c] = 'A';
        
        for(int i=0; i<4; i++){
            int row = r + di[i];
            int col = c + dj[i];
            
            if(isValid(row, col, board) && !visited[row][col] && board[row][col] == 'O'){
                dfs(row, col, board, visited, di, dj);
            }
        }
    }
    boolean validCheck(int r, int c, char[][] board){
        return (r != 0 && c != 0 && r != board.length - 1 && c != board[0].length - 1);
    }
    boolean isValid(int r, int c, char[][] arr){
        if(r >= 0 && c >= 0 && r < arr.length && c < arr[0].length){
            return true;
        }
        
        return false;
    }
}