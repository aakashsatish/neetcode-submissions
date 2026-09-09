class Solution {
    int count;
    public int numIslands(char[][] grid) {
        count = 0;
        int ROWS = grid.length;
        int COLS = grid[0].length;
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(grid[r][c] == '1'){
                    dfs(grid, r, c);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int r, int c){
        int ROWS = grid.length;
        int COLS = grid[0].length;
        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}
