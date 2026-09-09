class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];
        ArrayList<List<Integer>> res = new ArrayList<>();

        for(int c  = 0; c < COLS; c++){
            dfs(0, c, pac, heights, heights[0][c]);
            dfs(ROWS - 1, c, atl, heights, heights[ROWS - 1][c]);
        }
        for(int r = 0; r < ROWS; r++){
            dfs(r, 0, pac, heights, heights[r][0]);
            dfs(r, COLS - 1, atl, heights, heights[r][COLS - 1]);
        }
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(pac[r][c] && atl[r][c]){
                    res.add(Arrays.asList(r,c));
                }
            }
        }
        return res;
    }
    public void dfs(int r, int c, boolean[][] ocean, int[][] heights, int prev){
        int ROWS = heights.length;
        int COLS = heights[0].length;
        if(r < 0 || c < 0 || ROWS <= r || COLS <= c || ocean[r][c] || heights[r][c] < prev){
            return;
        }
        ocean[r][c] = true;
        dfs(r + 1, c, ocean, heights, heights[r][c]);
        dfs(r - 1, c, ocean, heights, heights[r][c]);
        dfs(r, c + 1, ocean, heights, heights[r][c]);
        dfs(r, c - 1, ocean, heights, heights[r][c]);
    }
}
