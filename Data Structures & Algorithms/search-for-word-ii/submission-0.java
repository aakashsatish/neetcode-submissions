class Solution {
    private HashSet<String> res;
    private int ROWS;
    private int COLS;
    public List<String> findWords(char[][] board, String[] words) {
        res = new HashSet<>();
        ROWS = board.length;
        COLS = board[0].length;
        for(String word : words){
            for(int r = 0; r < board.length; r++){
                for(int c = 0; c < board[0].length; c++){
                    if(dfs(board, word, r, c, 0)){
                        res.add(word);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    public boolean dfs(char[][] board, String word, int r, int c, int i){
        if(i == word.length()){
            return true;
        }
        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || board[r][c] != word.charAt(i)){
            return false;
        }
        board[r][c] = '#';
        
        boolean result = dfs(board, word, r + 1, c, i + 1)|| 
        dfs(board, word, r - 1, c, i + 1) || dfs(board, word, r, c + 1, i + 1)
        || dfs(board, word, r, c - 1, i + 1);
        
        board[r][c] = word.charAt(i);
        return result;
    }
}