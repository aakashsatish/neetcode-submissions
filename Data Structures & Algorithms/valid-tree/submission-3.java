class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length > n){
            return false;
        }
        ArrayList<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        HashSet<Integer> visited = new HashSet<>();
        if(!dfs(0, -1, adj, visited)){
            return false;
        }
        return n == visited.size();
    }
    public boolean dfs(int node, int parent, ArrayList<List<Integer>> adj, HashSet<Integer> visited){
        if(visited.contains(node)){
            return false;
        }
        visited.add(node);
        for(int nei : adj.get(node)){
            if(nei == parent){
                continue;
            }
            if(!dfs(nei, node, adj, visited)){
                return false;
            }
        }
        return true;
    }
}
