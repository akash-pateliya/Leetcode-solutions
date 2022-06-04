class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        
        boolean[] leftRow = new boolean[n];
        boolean[] upperDiagonal = new boolean[2*n-1];
        boolean[] lowerDiagonal = new boolean[2*n-1];
        List<List<String>> ans = new ArrayList<>();
        solve(0, board, ans, leftRow, upperDiagonal, lowerDiagonal);
        return ans;
    }
    
    void solve(int col, char[][] board, List<List<String>> ans, boolean[] leftRow,boolean[] upperDiagonal ,boolean[] lowerDiagonal){
        if(col == board.length){
            List<String> list = new ArrayList<String>();
            for(char[] arr: board){
                String str = "";
                for(char ch: arr){
                    str += ch;
                }
                list.add(str);
            }
            ans.add(new ArrayList<String>(list));
        }
        
        for(int row=0; row<board.length; row++){
            if(!leftRow[row] && !lowerDiagonal[row + col] && !upperDiagonal[board.length - 1 + col - row]){
                board[row][col] = 'Q';
                leftRow[row] = true;
                lowerDiagonal[row + col] = true;
                upperDiagonal[board.length - 1 + col - row] = true;
                solve(col+1, board, ans, leftRow, upperDiagonal, lowerDiagonal);
                upperDiagonal[board.length - 1 + col - row] = false;
                lowerDiagonal[row + col] = false;
                leftRow[row] = false;
                board[row][col] = '.';
            }
        }  
    }
}