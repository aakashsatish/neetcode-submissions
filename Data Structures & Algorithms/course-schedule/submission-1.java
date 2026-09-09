class Solution {
    HashMap<Integer, List<Integer>> preMap = new HashMap<>();
    HashSet<Integer> set = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < numCourses; i++){
            preMap.put(i, new ArrayList<>());
        }
        for(int[] preq: prerequisites){
            preMap.get(preq[0]).add(preq[1]);
        }
        for(int c = 0; c < numCourses; c++){
            if(!dfs(c)){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int crs){
        if(preMap.get(crs).isEmpty()){
            return true;
        }
        if(set.contains(crs)){
            return false;
        }
        set.add(crs);
        for(int c : preMap.get(crs)){
            if(!dfs(c)){
                return false;
            }
        }
        set.remove(crs);
        preMap.put(crs, new ArrayList<>());
        return true;
    }
}
