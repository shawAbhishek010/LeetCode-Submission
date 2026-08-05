class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j] && isComplete(i, j, 0, word, board))
                    return true;
            }
        }
        return false;
    }

    public boolean isComplete(int i, int j, int idx, String word, char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if (idx == word.length())
            return true;
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == '$')
            return false;
        if (board[i][j] != word.charAt(idx))
            return false;
        //now char matched
        char temp = board[i][j];
        board[i][j] = '$';
       
        if (isComplete(i, j + 1, idx + 1, word, board) ||       //moving right
                isComplete(i, j - 1, idx + 1, word, board) ||  //moving left 
                isComplete(i - 1, j, idx + 1, word, board) || //moving up
                isComplete(i + 1, j, idx + 1, word, board))  //moving down
            return true;
        board[i][j] = temp;
        return false;
    }
}