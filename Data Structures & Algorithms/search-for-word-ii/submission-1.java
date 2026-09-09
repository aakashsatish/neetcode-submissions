class TrieNode{
    private HashMap<Character, TrieNode> children;
    private boolean isWord;
    public TrieNode(){
        children = new HashMap<>();
        isWord = false;
    }
    public void addWord(String word){
        TrieNode curr = this;
        for(char c : word.toCharArray()){
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.isWord = true;
    }
}

class Solution {
    private HashSet<String> set;
    private boolean[][] visited;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(String word: words){
            root.addWord(word);
        }
        int ROWS = board.length;
        int COLS = board[0].length;
        set = new HashSet<>();
        visited = new boolean[ROWS][COLS];
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                dfs(board, r, c, root, "");
            }
        }
        return new ArrayList<>(set);
    }

    public void dfs(char[][] board, int r, int c, TrieNode node, String word){
       int ROWS = board.length;
       int COLS = board[0].length;
       if(r < 0 || c < 0 || r >= ROWS || c >= COLS || visited[r][c] || !node.children.containsKey(board[r][c])){
        return;
       }
       visited[r][c] = true;
       node = node.children.get(board[r][c]);
       word += board[r][c];
       if(node.isWord){
        set.add(word);
       }
       dfs(board, r + 1, c, node, word);
       dfs(board, r - 1, c, node, word);
       dfs(board, r, c + 1, node, word);
       dfs(board, r, c - 1, node, word);
       visited[r][c] = false;
    }
}
