class Solution {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        boolean[] visit = new boolean[n];
        for(int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int res = 0;

        for(int c = 0; c < n; c++){
            if(!visit[c]){
                dfs(c, adj, visit);
                res++;
            }
        }
        return res;
    }
    public void dfs(int c, HashMap<Integer, List<Integer>> adj, boolean[] visit){
        visit[c] = true;
        for(int nei : adj.get(c)){
            if(!visit[nei]){
                dfs(nei, adj, visit);
            }
        }
    }
}
