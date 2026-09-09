class Solution {
    private HashMap<Integer, List<Integer>> pre = new HashMap<>();
    private HashSet<Integer> visit = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < numCourses; i++){
            pre.put(i, new ArrayList<>());
        }
        for(int[] preq : prerequisites){
            pre.get(preq[0]).add(preq[1]);
        }
        for(int c = 0; c < numCourses; c++){
            if(!dfs(c)){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int crs){
        if(pre.get(crs).isEmpty()){
            return true;
        }
        if(visit.contains(crs)){
            return false;
        }
        visit.add(crs);
        for(int c : pre.get(crs)){
            if(!dfs(c)){
                return false;
            }
        }
        pre.put(crs, new ArrayList<>());
        visit.remove(crs);
        return true;
    }
}
